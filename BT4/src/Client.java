import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

public class Client {
    final static Logger logger = Logger.getLogger("Client");
    public static void main(String[] arg) throws IOException {
        while (true){
            System.out.print("Input your command: ");
            String command = new Scanner(System.in).nextLine() + "\n";
            Socket socket = new Socket("127.0.0.1",2505);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            System.out.println(br.read());
            dataOutputStream.writeBytes(command);
            logger.info("--------send-msg----------");
            System.out.println(br.readLine());
            socket.close();
        }
    }
}
