import java.io.*;
import java.net.*;
public class echoserver{
public static void main(String [] args) throws Exception{
try{
int port;
BufferedReader Buf =new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter the Port address:");
port = Integer.parseInt(Buf.readLine());
ServerSocket sok = new ServerSocket(port);
System.out.println("Waiting...");
Socket so =sok.accept();
if(so.isConnected() == true)
System.out.println("Client Socket is Connected Successfully");
InputStream in = so.getInputStream();
OutputStream ou = so.getOutputStream();
PrintWriter pr = new PrintWriter(ou);
BufferedReader buf = new BufferedReader(new InputStreamReader(in));
String str = buf.readLine();
System.out.println("Message Recieved From Client:"+str);
System.out.println("This Message is Forwarded To Client");
pr.println(str);
pr.flush();
}
catch(Exception e){
System.out.println("Error:"+e.getMessage());
}
}
}