import java.io.*;
import java.net.*;

class TraceRoute{
public static void main(String [] args) throws Exception{
String arr;
String str;
System.out.println("Enter the website address to PING:");
BufferedReader buf1 = new BufferedReader(new InputStreamReader(System.in));
String ip = buf1.readLine();
Runtime h = Runtime.getRuntime();
Process p = h.exec("tracert " + ip);
InputStream in = p.getInputStream();
BufferedReader buf2 = new BufferedReader(new InputStreamReader(in));
while((str=buf2.readLine())!=null){
System.out.println(" " + str);
}
}
}