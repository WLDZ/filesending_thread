import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class ServerThread implements Runnable
{
	
	Socket clientSocket;
	Server server;
	BufferedReader keyboard =null;
	BufferedReader clientReader=null;
	BufferedOutputStream output = null;
	BufferedInputStream input =null;
	ObjectInputStream   ois =null;
	ObjectOutputStream  oos =null;		
	BufferedWriter writer;
	FileInputStream fis = null;
	BufferedInputStream bis = null;
	OutputStream os = null;
	DataOutputStream dos = null;
	DataInputStream dis =null;
	
	int Id;
	File [] list;
	int sizeOfFile; 

	public ServerThread(Socket cs, int Id)
	{	
		this.clientSocket = cs;
		this.Id= Id;
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		String dir = "C:\\Users\\WALEED\\Desktop\\fyp" ;
		File f = new File(dir);
		System.out.println("Path : " + f.getAbsolutePath());
		list = f.listFiles();
		
		for (int i =0 ; i <list.length;i++)
		{
			System.out.println( i +" " +list[i].getName()+" Size " +list[i].length() + " Bytes ");
		}

		
		try 
		{
			writer =new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

			output = new BufferedOutputStream(clientSocket.getOutputStream());
			input = new BufferedInputStream(clientSocket.getInputStream());
			os = clientSocket.getOutputStream();
		
			dos= new DataOutputStream(clientSocket.getOutputStream());
			dis = new DataInputStream (clientSocket.getInputStream());

		
		} catch (IOException e) 
		
		{
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	

	@Override
	public void run() 
	{
		
		try
		{
			
			File myFile = new File ("C:\\Users\\WALEED\\Desktop\\fyp\\Maroon 5 - Sugar - PlayIt.pk.mp4");
/*			fis = new FileInputStream(myFile);
	        bis = new BufferedInputStream(fis);
	        System.out.println(myFile.length())*/;
		
	        
			int bytesRead;
			byte[] buffer = new byte[1024];
			System.out.println(buffer.length);
			
			long f = myFile.length();
			System.out.println(f);
			dos.writeLong(f);
			dos.flush();
			
			
			String name = myFile.getName();
			System.out.println(name);
			writer.write(name + "\n");
			writer.flush();
			
			
			sizeOfFile = list.length;
			writer.write(sizeOfFile);
			writer.flush();
			
			
			for (int i =0 ; i <list.length;i++)
			{
				
				if (list[i].isDirectory())
				{
//					System.out.println( i +" " +list[i].getName()+" Size " +list[i].length() + " Bytes  Folder " );
//					name[i] = list[i].getName().concat("  Folder ");
//					name[i] = list[i].getName()+("  Folder ");
					   writer.write(list[i].getName() +("  Folder ") + "\n");
					   writer.flush();
				}
				else
				{
				   writer.write(list[i].getName() + "\n");
				   writer.flush();
			   }
			}
			
			System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]]]]]]]]]]");
			int indexOffile = dis.read();
			System.out.println(indexOffile);
			
			fis = new FileInputStream(list[indexOffile].getAbsolutePath());
	        bis = new BufferedInputStream(fis);
			
	        f = list[indexOffile].length();
			System.out.println(f);
			dos.writeLong(f);
			dos.flush();
	        
			
			int z =0;
			System.out.println (myFile.length());
			while
				(( bytesRead = bis.read(buffer,0,1024 )) >=0 ) 
			{
				
					z = z+bytesRead;
					System.out.println(z);
					output.write( buffer, 0,bytesRead );
					output.flush();
					System.out.println(bytesRead);

			}
			
			
			System.out.println("kkkkkkk");
			
		
		}
		 catch (IOException e) 
			
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	

}
