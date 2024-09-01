import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCP_numberServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(1212);
        Socket socket=serverSocket.accept();
        System.out.println("Server is connected...");

        //send/write

        Scanner scanner=new Scanner(socket.getInputStream());//read
        PrintStream printStream=new PrintStream(socket.getOutputStream());
        String msg=scanner.nextLine();
        int n=Integer.parseInt(msg);

        if(n>0)
            System.out.println(msg +" is +ve");
        else if (n<0) {
            System.out.println(msg +" is -ve");
        }
        else System.out.println(msg + " is zero");

        String msg2="I am server";
        printStream.println(msg2);

        socket.close();
    }
}
