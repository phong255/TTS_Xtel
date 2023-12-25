package ThreadChats;

import Sockets.Server;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.io.IOException;


public class ServerThread implements  Runnable{
    final Logger logger = Logger.getLogger(ServerThread.class);
    Server server;
    JTextArea messages;

    public ServerThread(Server server, JTextArea messages){
        this.server = server;
        this.messages = messages;
    }
    @Override
    public void run() {
        try{
            //Thread riêng để nhận tin
            String messAccept = "";
            while((messAccept = server.getMessage()) != null){
                messages.append(messAccept + "\n");
            }
        }
        catch (IOException e){
            logger.error(e.getMessage(),e.getCause());
        }
    }
}
