import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Server {
    final static Logger logger = Logger.getLogger("Server");
    public static void main(String[] arg) throws IOException {
        ServerSocket server = new ServerSocket(2505);
        while(true){
            Socket socket_accept = server.accept();
            logger.info("--------connected---------");
            BufferedReader br = new BufferedReader(new InputStreamReader(socket_accept.getInputStream()));
            DataOutputStream dataOutputStream = new DataOutputStream(socket_accept.getOutputStream());
            String msg = br.readLine();
            logger.info("-----take-msg------: " + msg);
            if(Integer.parseInt(msg)==1)
                dataOutputStream.writeBytes("Hello bay be !!\n");
            else if(Integer.parseInt(msg)==2)
                dataOutputStream.writeBytes("Make yourself stupid dog !!\n");
            else if(msg.isEmpty()){
                dataOutputStream.writeBytes("What's up bro!\n");
//                dataOutputStream.writeBytes("Make required:1. Say Hi!2. 25 + 5 = ?\n");
            }
            logger.info("----------send-msg----------");
            socket_accept.close();
        }
    }
}
