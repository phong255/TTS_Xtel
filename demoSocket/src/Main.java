import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2505);
        String msg_from_client;
        boolean bool = true;
        while(true){
            Socket connectSocket = serverSocket.accept();
            DataOutputStream dataOutputStream = new DataOutputStream(connectSocket.getOutputStream());
            BufferedReader bw = new BufferedReader(new InputStreamReader(connectSocket.getInputStream()));
            msg_from_client = bw.readLine();
            System.out.println("Message from client: ");
            if(msg_from_client != null)
                System.out.println(msg_from_client);
            else
                System.out.println("Nothing from client!");
            if(msg_from_client.equals("Bye")){
                dataOutputStream.writeBytes("Gud bye!");
            }
            bw.close();
            return;
        }
    }
}