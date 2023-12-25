package UIChats;

import Sockets.Client;
import ThreadChats.ClientThread;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class UIClient {
    final static Logger logger = Logger.getLogger(UIClient.class);

    public static void init(String host,int port) throws IOException {
        Client client = new Client(host,port);
//        -------Giao dien chat box client------------------------------------
        JFrame frame = new JFrame();
        frame.setTitle("Client " + client.getInfo());
        frame.setSize(500, 500);
        JTextArea messages = new JTextArea();
        messages.setBounds(10, 10, 460, 150);
        messages.setEditable(false);
        frame.add(messages);
        JTextField textField = new JTextField();
        textField.setBounds(10, 170, 460, 30);
        frame.add(textField);
        JButton btnSend = new JButton("Send");
        btnSend.setBounds(100, 250, 300, 30);
        JButton btnStart = new JButton("Start");
        btnStart.setBounds(100, 300, 300, 30);
        class ButtonListener implements ActionListener {
            String send_msg;

            public ButtonListener(String send_msg) {
                this.send_msg = send_msg;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                send_msg = textField.getText();
                try {
                    client.sendMessage(send_msg);
                    logger.info("send message");
                } catch (IOException ex) {
                    logger.error(ex.getMessage(),ex.getCause());
                }
            }
        }
        btnSend.addActionListener(new ButtonListener(textField.getText()));
        frame.add(btnSend);
        class ButtonStartListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                messages.append("Connecting...\n");
                String messAccept="";
                Thread clientThread = new Thread(new ClientThread(client, messages));
                clientThread.start();
            }
        }
        btnStart.addActionListener(new ButtonStartListener());
        frame.add(btnStart);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    client.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.exit(0);
            }
        });
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
//      -----------------------------------------------------------
    }
    public static void main(String[] arg){
        try{
            init("127.0.0.1",2505);
        }
        catch (IOException e){
            logger.error(e.getMessage(),e.getCause());
        }
    }
}
