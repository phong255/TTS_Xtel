import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    public Client(){
    }
    public static void main(String[] args) throws IOException{
            Socket clientSocket = new Socket("127.0.0.1",2505);
            Scanner sc = new Scanner(System.in);
            System.out.println("Message to server: ");
            String msg = sc.nextLine();
            DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
            dataOutputStream.writeBytes(msg);
            System.out.println(" Success !");
//            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//            if(br.readLine() == null)
//                System.out.println("Nothing from server");
//            else System.out.println(br.readLine());
//            br.close();
            clientSocket.close();
    }
}
