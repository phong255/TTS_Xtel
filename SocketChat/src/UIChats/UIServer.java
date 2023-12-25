package UIChats;

import Sockets.Server;
import ThreadChats.ServerThread;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class UIServer{
    final static Logger logger = Logger.getLogger(UIServer.class);

    public static void init(int port) throws IOException {
        Server server = new Server(port);
        //-------Giao dien chat box server------------------------------------
        JFrame frame = new JFrame();
        frame.setTitle("Server " + server.getPort());
        frame.setSize(500, 500);
        JTextArea messages = new JTextArea();
        messages.setBounds(10, 10, 460, 150);
        messages.setEditable(false);
        frame.add(messages);
        JTextField textField = new JTextField();
        textField.setBounds(10, 170, 460, 30);
        frame.add(textField);
        JButton btnSend = new JButton("Send");      //Nút gửi tin nhắn
        btnSend.setBounds(100, 220, 300, 30);
        JButton btnStart = new JButton("Start");    //Nút tạo socket chờ kết nối từ server
        btnStart.setBounds(100, 270, 300, 30);
        JButton btnClose = new JButton("Close");    //Đóng kết nối từ socket của server
        btnClose.setBounds(100, 320, 300, 30);
        class ButtonListener implements ActionListener {
            String send_msg;

            public ButtonListener(String send_msg) {
                this.send_msg = send_msg;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                send_msg = textField.getText();
                try {
                    server.sendMessage(send_msg);
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
                try {
                    messages.append("Starting server ...");
                    messages.append("Connecting...\n");
                    server.getConnect();
                    Thread serverThread = new Thread(new ServerThread(server,messages));
                    serverThread.start();
                } catch (IOException ex) {
                    logger.error(ex.getMessage(),ex.getCause());
                }
            }
        }
        btnStart.addActionListener(new ButtonStartListener());
        frame.add(btnStart);
        class ButtonCloseListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    messages.append("Closed"+"\n");
                    server.close();
                } catch (IOException ex) {
                    logger.error(ex.getMessage(),ex.getCause());
                }
            }
        }
        btnClose.addActionListener(new ButtonCloseListener());
        frame.add(btnClose);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    server.close();
                } catch (IOException ex) {
                    logger.error(ex.getMessage(),ex.getCause());
                }
                System.exit(0);
            }
        });
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] arg){
        try{
            init(2505);
        }
        catch (IOException e){
            logger.error(e.getMessage(),e.getCause());
        }
    }
}
