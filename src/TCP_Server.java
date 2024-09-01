import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCP_Server {
    public static void main(String[] args)throws IOException {
        ServerSocket serverSocket=new ServerSocket(4567);

        while (true) {
            Socket socket = serverSocket.accept();//received the connection //serversocket.accept returns a Socket//socket refers to the client
            System.out.println("Connection established...");

            //Sending/write msg(outputstream)
            PrintStream printStream = new PrintStream(socket.getOutputStream());//PrintStream is used to send message//socket is object of client
           // printStream.print("Hello! I am server...\nGreeting from CSE building...");
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter message to be sent : ");
            String msg=scanner.nextLine();
            printStream.print(msg);
            socket.close();

        }


    }
}
