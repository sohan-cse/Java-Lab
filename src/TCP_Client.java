import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCP_Client {
    public static void main(String[] args)throws IOException {
        Socket socket=new Socket("localhost",4567);//this socket points to the server
        System.out.println("Connection request sent...");

        //Read/receiving msg(inputstream)
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String msg=bufferedReader.readLine();
        System.out.println("Received message from server : "+msg);
        socket.close();

    }
}
