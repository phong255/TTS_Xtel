package ThreadChats;

import Sockets.Client;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.io.IOException;

public class ClientThread implements Runnable{
    final Logger logger = Logger.getLogger(ClientThread.class);
    Client client;
    JTextArea messages;

    public ClientThread(Client client, JTextArea messages){
        this.client = client;
        this.messages = messages;
    }
    @Override
    public void run() {
        try{
            String messAccept;
            while((messAccept = client.getMessage()) != null){
                messages.append(messAccept+"\n");
            }
        }
        catch (IOException e) {
            logger.error(e.getMessage(), e.getCause());
        }
    }
}
