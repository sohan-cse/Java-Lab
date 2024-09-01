import java.io.IOException;
import java.net.*;

public class UDP_Client {
    public static void main(String[] args)throws SocketException, UnknownHostException, IOException {
        DatagramSocket datagramSocket=new DatagramSocket();
        System.out.println("Client started...");
        //sent a message
        String msg="Hello! I am Client";
        byte b[]=msg.getBytes();//sent as a byte form
        InetAddress inetAddress=InetAddress.getByName("localhost");//inetaddress is the ip adress of java form
        DatagramPacket dpac=new DatagramPacket(b,b.length,inetAddress,2345);
        datagramSocket.send(dpac);
        System.out.println("Packet is sent...");
        //receiving part
        byte b1[]=new byte[1000];
        DatagramPacket datagramPacket=new DatagramPacket(b1,b1.length);
        datagramSocket.receive(datagramPacket);
        String receivedServerMsg=new String(datagramPacket.getData(),0,datagramPacket.getLength());
        System.out.println("Received message from server is : "+receivedServerMsg);
        datagramSocket.close();

    }
}
