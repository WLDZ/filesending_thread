import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client 
{
	static ObjectInputStream   ois =null;
	static ObjectOutputStream  oos =null;	
	public static void main (String[] args)
	{
		
		String hostname="localhost";
		int portnumber = 2112;
		
		
		try 
		{
			Socket client = new Socket(hostname,portnumber);
			
			byte[] buffer = new byte[1024];
			int bytesRead = buffer.length;
			System.out.println(buffer.length);
			int z =0;
	
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			Scanner cin = new Scanner(System.in);
			DataInputStream dis = new DataInputStream (client.getInputStream());
			InputStream is = client.getInputStream();
			BufferedReader clientReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			long size =dis.readLong();
	        System.out.println("size = "+size);
	        
	        String name1 = dis.readLine();
	        System.out.println(name1);
	        FileOutputStream fos1 = new FileOutputStream(name1);
	        BufferedOutputStream bos1 = new BufferedOutputStream(fos1);
	        
	        
	        
	        List <String> names = new ArrayList<String>();
			String msg ;
			int lim = dis.read();
			for(int i = 0 ; i<lim ; i++)
			{
				msg = dis.readLine();
				names.add(msg);

			}
	        
			System.out.println("Index  Name of File");
			System.out.println("-----------------------------------------------");
			
			String[] newNames = new String[names.size()];
			for(int i = 0 ; i<names.size() ; i++)
			{
				newNames[i] = names.get(i);
				System.out.println(i +" " + names.get(i));
			}
			
			
	        	   
//-------------------------------------------------------------------------------------			
			
			File f1 = new File("");
			System.out.println("Path : " + f1.getAbsolutePath());
			String p = f1.getAbsolutePath();
			System.out.println(p);
			File f2 = new File(p);
			System.out.println(f2.length());
			
			File [] list = f2.listFiles();
			String [] name = new String[list.length];
			for (int i =0 ; i <list.length;i++)
			{
				if (list[i].isDirectory())
				{
					System.out.println( i +" " +list[i].getName()+" Size " +list[i].length() + " Bytes  Folder " );
//					name[i] = list[i].getName().concat("  Folder ");
					name[i] = list[i].getName()+("  Folder ");
					
				}
				else
				{
					System.out.println( i +" " +list[i].getName()+" Size " +list[i].length() + " Bytes ");
					name[i] = list[i].getName();
				}
			

			}
			
			System.out.println("----------------------");
			for (int i =0 ; i <name.length;i++)
			{
				System.out.println(i+ " "+name[i]);
			}
			
			System.out.println("=-------===------------=======");
			
			
			String[] s1 = {".classpath", ".project", "11007724_855060337874173_5347715315455782707_n.png", "1505666_624000557663503_1193621644_n.jpg", "aa.mp4", "bin", "Live Migration of Multiple Virtual Machines with Resource Reservation in Cloud.pdf"};
	        List<String> s1List = new ArrayList(Arrays.asList(newNames));

	        for(int i =0;i<name.length;i++)
	        {
	            if (s1List.contains(name[i])) 
	            {
	                s1List.remove(name[i]);
	            } else {
	                s1List.add(name[i]);
	            }
//	             System.out.println("intersect on " + s1List);
	        }
	        
			System.out.println(s1List.size());
			System.out.println("==================================================");
			for(int i =0;i < s1List.size();i++)
			{
				System.out.println(i +"  "+s1List.get(i));
			}
			
			System.out.println(newNames.length);
			System.out.println("llllllllllllllllllllllllllll");
			for(int i =0;i < s1List.size();i++)
			{
//				System.out.println(i);	
				for(int j =0;j < newNames.length;j++)
				{
					if(s1List.get(i).equals(newNames[j]))
					{
//						System.out.println( j +" " +newNames[j]+ " Size " +list[j].length() + " Bytes ");
						System.out.println( j +" " +newNames[j]);
					}
					
				}
			}
			
			
			
			
//			------------------------------------------------------------
			
			
			System.out.println("Please Enter The Index Of The File To Download It");
		
	        Pattern p1 = Pattern.compile("^\\d+$");
	        Matcher numberMatcher;
	        String ind ="";
	        int index= -1;
	        boolean check = false;
	        boolean subCheck = false;

	        	while (check==false)
	        	{
		        		ind = cin.next();
		        		int x = Integer.parseInt(ind); 
		        		CharSequence a = "Folder";
		        		if (x < newNames.length)
		        		{
		        		String s = newNames[x];
		        		subCheck = s.contains(a);
		        		System.out.println(s.contains(a));
		        		}
		        		
		        		numberMatcher = p1.matcher(ind);
		                if (numberMatcher.matches() && subCheck == false )
		                {
		                    if (Integer.parseInt(ind) < names.size() && Integer.parseInt(ind) >= 0)
		                    {
		                    	index = Integer.parseInt(ind);
		                    	writer.write(index);
		                    	writer.flush();
		                    	check = true;
		                    }
		                }
	        		System.out.println("Please Enter The Correct Index Or The File Your Are Trying To Download Is A FOLDER");
	        	}
	        
	        FileOutputStream fos = new FileOutputStream(names.get(index));
	        BufferedOutputStream bos = new BufferedOutputStream(fos);
	        size =dis.readLong();
	        System.out.println("size = "+size);

			
			while(z !=size  ) 
			
			{
				 	bytesRead = is.read(buffer);
					z = z+bytesRead;	
					System.out.println(z);
					bos.write( buffer);
					System.out.println(bytesRead);
					bos.flush();
					
			}
			

			System.out.println("Succesufully downloaded the File :)");
		}		
		catch (UnknownHostException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}	
			

		
	}

}
