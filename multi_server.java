import java.io.*;
import java.net.*;



class MyThread extends Thread
{
	Socket sock;
	public PrintWriter pwrite;
	public multi_server parent;
	//multi_server parent;
	MyThread my_thread1;
	MyThread my_thread2;
	MyThread my_thread3;
	MyThread my_thread4;
	MyThread my_thread5;

	public void wrapper(Socket s, MyThread my_thread1, MyThread my_thread2, MyThread my_thread3, MyThread my_thread4, MyThread my_thread5)
	{
		this.my_thread1 = my_thread1;
		this.my_thread2 = my_thread2;
		this.my_thread3 = my_thread3;
		this.my_thread4 = my_thread4;
		this.my_thread5 = my_thread5;
		this.sock = s;
		this.start();
	}
	
	
	public void run()
	{
		try
		{
			//BufferedReader sendRead = new BufferedReader(new InputStreamReader(System.in));
			OutputStream ostream = sock.getOutputStream();
			this.pwrite = new PrintWriter(ostream, true);
			InputStream istream = sock.getInputStream();
			BufferedReader receiveread = new BufferedReader(new InputStreamReader(istream));
			//for(int i = 0, i < 3; i++)
			//{
			//	Socket sock = sersock.accept();
			//	BufferedReader sendRead = new BufferedReader(new InputStreamReader(System.in));
			//	OutputStream ostream = sock.getOutputStream();
			//	PrintWriter pwrite = new PrintWriter(ostream, true);
			//	InputStream istream = sock.getInputStream();
			//	BufferedReader receiveread = new BufferedReader(new InputStreamReader(istream));
			//}
			String r_msg, s_msg;
			while(true)
			{
				if((r_msg = receiveread.readLine()) != null)
				{
					/*
					System.out.println(">>>> " + r_msg);
					*/

					if(this.my_thread1.sock.isConnected()) this.my_thread1.pwrite.println(r_msg);
					if(this.my_thread2.sock.isConnected()) this.my_thread2.pwrite.println(r_msg);
					if(this.my_thread3.sock.isConnected()) this.my_thread3.pwrite.println(r_msg);
					if(this.my_thread4.sock.isConnected()) this.my_thread4.pwrite.println(r_msg);
					if(this.my_thread5.sock.isConnected()) this.my_thread5.pwrite.println(r_msg);
					System.out.flush();
				}
	
				//System.out.print("You: ");
				//s_msg = sendRead.readLine();
				//pwrite.println(s_msg);
				//System.out.flush();
			}
		}
		catch(Exception e)
		{
			System.out.println("\n\nERROR!!!!!!\n\n");
		}
	}
}









public class multi_server
{
	static MyThread my_thread1;
	static MyThread my_thread2;
	static MyThread my_thread3;
	static MyThread my_thread4;
	static MyThread my_thread5;

	public static void main(String args[]) throws Exception
	{
		BufferedReader sendRead = new BufferedReader(new InputStreamReader(System.in));
		my_thread1 = new MyThread();
		my_thread2 = new MyThread();
		my_thread3 = new MyThread();
		my_thread4 = new MyThread();
		my_thread5 = new MyThread();
		ServerSocket sersock = new ServerSocket(9999);
		System.out.println("\n\nServer ready for chatting.\n\n");
		my_thread1.wrapper(sersock.accept(), my_thread1, my_thread2, my_thread3, my_thread4, my_thread5);
		my_thread2.wrapper(sersock.accept(), my_thread1, my_thread2, my_thread3, my_thread4, my_thread5);
		my_thread3.wrapper(sersock.accept(), my_thread1, my_thread2, my_thread3, my_thread4, my_thread5);
		my_thread4.wrapper(sersock.accept(), my_thread1, my_thread2, my_thread3, my_thread4, my_thread5);
		my_thread5.wrapper(sersock.accept(), my_thread1, my_thread2, my_thread3, my_thread4, my_thread5);
		//my_thread1.parent = this;
		//my_thread2.parent = this;
		//my_thread3.parent = this;
		//OutputStream ostream = sock.getOutputStream();
		//PrintWriter pwrite = new PrintWriter(ostream, true);
		//InputStream istream = sock.getInputStream();
		//BufferedReader receiveread = new BufferedReader(new InputStreamReader(istream));

		//for(int i = 0, i < 3; i++)
		//{
		//	Socket sock = sersock.accept();
		//	BufferedReader sendRead = new BufferedReader(new InputStreamReader(System.in));
		//	OutputStream ostream = sock.getOutputStream();
		//	PrintWriter pwrite = new PrintWriter(ostream, true);
		//	InputStream istream = sock.getInputStream();
		//	BufferedReader receiveread = new BufferedReader(new InputStreamReader(istream));
		//}

		String s_msg;
		while(true)
		{
		//	if((r_msg = receiveread.readLine()) != null)
		//	{
		//		System.out.println(">>>> " + r_msg);
		//	}

			
			/*
			System.out.print("You: ");
			s_msg = sendRead.readLine();
			my_thread1.pwrite.println(s_msg);
			my_thread2.pwrite.println(s_msg);
			my_thread3.pwrite.println(s_msg);
			System.out.flush();
			*/
		}
	}
}
