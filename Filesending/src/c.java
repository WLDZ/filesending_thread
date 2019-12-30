import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class c
{
	static FileInputStream fis = null;
	static BufferedInputStream bis = null;
	static BufferedOutputStream output = null;
	static BufferedInputStream input =null;
	
	public static void main(String[] args) throws IOException
	{
/*		String dir = "C:\\Users\\WALEED\\Desktop\\fyp" ;
		File f = new File(dir);
		System.out.println("Path : " + f.getAbsolutePath());
		System.out.println(f.length());
		
		
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
//				name[i] = list[i].getName().concat("  Folder ");
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
        List<String> s1List = new ArrayList(Arrays.asList(name));

        for(int i =0;i<s1.length;i++)
        {
            if (s1List.contains(s1[i])) 
            {
                s1List.remove(s1[i]);
            } else {
                s1List.add(s1[i]);
            }
//             System.out.println("intersect on " + s1List);
        }
        
//		System.out.println(s1List.size());
		
		for(int i =0;i < s1List.size();i++)
		{
			System.out.println(s1List.get(i));
		}
		
		
		System.out.println("llllllllllllllllllllllllllll");
		for(int i =0;i < s1List.size();i++)
		{
			for(int j =0;j < name.length;j++)
			{
								
				if(s1List.get(i).equals(name[j]))
				{
					System.out.println( j +" " +name[j]+ " Size " +list[j].length() + " Bytes ");
				}
			}
		}*/
		
		
		
		
	/*	int count = 0 ;
		
		for (int i =0 ; i <list.length;i++)
		{
			if (list[i].canRead())
			{
				count ++ ; 
			}
		}
		System.out.println(count);
*///		System.out.println(list[0].getName());
//		BufferedInputStream in = new BufferedInputStream( new FileInputStream(list[0]));
		
//		File myFile = new File ("C:\\Users\\WALEED\\Desktop\\fyp.");
//		System.out.println(myFile.getName());
//		System.out.println(myFile.length());
//		fis = new FileInputStream(myFile);
//		FileOutputStream fos = new FileOutputStream("aa.mp4");
////        bis = new BufferedInputStream(fis);
//        BufferedOutputStream bos = new BufferedOutputStream(fos);
		
   /* 	output = new BufferedOutputStream(clientSocket.getOutputStream());
		input = new BufferedInputStream(clientSocket.getInputStream());
    */    
//        
//        int bytesRead;
////		BufferedInputStream in = new BufferedInputStream( new FileInputStream(list[0]));
//		byte[] buffer = new byte[1024];
////		bytesRead = bis.read(buffer,0,1024);
//		System.out.println(buffer.length);
////		System.out.println(bytesRead);
//		int	count =0;
//		int z =0;
//		System.out.println (myFile.length());
//		while
//			(( bytesRead = bis.read(buffer, 0,1024 )) >0 ) 
//		{
//			
//				z = z+bytesRead;
//				System.out.println(bytesRead);
//				System.out.println(z);
//				bos.write( buffer, 0,bytesRead );
//				bos.flush();
////				System.out.println(bytesRead);
//		}
//		System.out.println("ddddddddd");
		
		
    /*    
        String[] AllUids = {"Joe", "Tom", "Dan", "Bill", "Hector", "Ron"};
        String[] EndUids = {"Dan", "Hector", "Ron"};
        
//        Set<String> activeUids = Sets.difference(AllUids, EndUids);
        
        
        
		
		System.out.println(s1List);*/
		CharSequence a = "Folder";
		String s = "bin  Folder";
		System.out.println(s.contains(a));
		
		
	}
}
