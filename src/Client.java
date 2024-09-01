import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)throws IOException {
        System.out.println("Client started...");
        Socket socket=new Socket("localhost",22222);
        System.out.println("Client connected succesfully");

        ObjectInputStream ois1=new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos2=new ObjectOutputStream(socket.getOutputStream());
        //ObjectInputStream ois1=new ObjectInputStream(socket.getInputStream());


        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");

        // Read the input string
        String message = scanner.nextLine();
        oos2.writeObject(message);

        try {
            Object fromServer=ois1.readObject();
            System.out.println("From server : "+(String) fromServer);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            ois1.close();
            oos2.close();
            scanner.close();
            socket.close();
        }


    }
}
