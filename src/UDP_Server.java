import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDP_Server {
    public static void main(String[] args)throws SocketException, IOException {
        DatagramSocket dsoc=new DatagramSocket(2345);
        System.out.println("Server started...");
        //receiving part
        byte b[]=new byte[1000];//received msg stored in b array
        DatagramPacket datagramPacket=new DatagramPacket(b, b.length);//received msg stored in b array as a package form
        dsoc.receive(datagramPacket);
        String receiveMsg=new String(datagramPacket.getData(),0,datagramPacket.getLength());
        System.out.println("Received data is : "+receiveMsg);
        //sending part
        String serverMsg="Hey! I am server";
        byte b1[]=serverMsg.getBytes();
        InetAddress inetAddress=InetAddress.getLocalHost();
        DatagramPacket datagramPacket1=new DatagramPacket(b1, b1.length,inetAddress,datagramPacket.getPort());
        dsoc.send(datagramPacket1);
        System.out.println("Message sent..");
        dsoc.close();


    }
}
