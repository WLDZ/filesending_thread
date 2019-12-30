
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server
{
	
	
	public void StartServer()
	{
		int port =2112;
		int numConections=0;
		ServerSocket ss = null;
		Socket clientSocket;
		
		try
		{
			ss= new ServerSocket(port);
			System.out.println("SERVER ");
			System.out.println("Waiting for client:");
			
			
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true)
		{
			try 
			{
				clientSocket=ss.accept();
				System.out.println(clientSocket.getPort());
				numConections++;
				System.out.println("Client" + " " + numConections + " " + "Connected" );
				ServerThread sc = new ServerThread(clientSocket,numConections);
				new Thread(sc).start();
				
				

			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}
	
	

	public static void main (String[] args)
	{
		new Server().StartServer();
		
	}
}
