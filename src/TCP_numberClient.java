import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TCP_numberClient {
    public static void main(String[] args)throws IOException {
        Socket socket=new Socket("localhost",1212);

        //user input
        Scanner scanner1=new Scanner(System.in);
        System.out.println("Enter any number : ");
        String str=scanner1.nextLine();

        //for sending data
        PrintStream printStream=new PrintStream(socket.getOutputStream());
        printStream.println(str);


        Scanner scanner2=new Scanner(socket.getInputStream());
        String msg=scanner2.nextLine();
        System.out.println(msg);
        socket.close();
    }
}
