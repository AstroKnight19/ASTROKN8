import java.net.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
class Server{
public static void main(String [] args) throws Exception{
ServerSocket server =null;
Socket socket;
server =new ServerSocket(4000);
System.out.println("Server Waiting for image");
socket =server.accept();
System.out.println("client connected");
InputStream in = socket.getInputStream();
DataInputStream dis =new DataInputStream(in);
int len =dis.readInt();
System.out.println("image size:" + len/1024 + "KB");
byte [] data = new byte[len];
dis.readFully(data);
dis.close();
in.close();
InputStream ian = new ByteArrayInputStream(data);
BufferedImage bImage =ImageIO.read(ian);
JFrame f = new JFrame("Server");
ImageIcon icon = new ImageIcon(bImage);
JLabel I =new JLabel();
I.setIcon(icon);
f.add(I);
f.pack();
f.setVisible(true);
}
}