import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

public class Server extends Thread{
    final static Logger logger = Logger.getLogger("Server");
    String name;
    ServerSocket server;
    CountDownLatch latch;
    public Server(CountDownLatch latch){
        this.latch = latch;
        this.start();
    }
    public Server(ServerSocket server,String name){
        this.name = name;
        this.server = server;
        this.start();
    }
    @Override
    public void run() {
        try{
            Socket socket_accept = server.accept();
            logger.info("--------connected---------:" + socket_accept.getPort());
            BufferedReader br = new BufferedReader(new InputStreamReader(socket_accept.getInputStream()));
            DataOutputStream dataOutputStream = new DataOutputStream(socket_accept.getOutputStream());
            //-------chat box server------------------------------------
            JFrame frame = new JFrame();
            frame.setTitle("Server");
            frame.setSize(300,400);
            JTextArea jTextArea = new JTextArea();
            jTextArea.setBounds(10,10, 260,150);
            jTextArea.setEditable(false);
            frame.add(jTextArea);
            JTextField textField = new JTextField();
            textField.setBounds(10,170, 260,30);
            frame.add(textField);
            JButton btn = new JButton("Send");
            btn.setBounds(100,250, 100,30);
            String msg;
            if((msg=br.readLine()) != null)
                jTextArea.append(msg + "\n");
            class ButtonListener implements ActionListener{
                String send_msg;
                public ButtonListener(String send_msg){
                    this.send_msg = send_msg;
                }
                @Override
                public void actionPerformed(ActionEvent e) {
                    send_msg = textField.getText() ;
                    try {
                        dataOutputStream.writeBytes(send_msg);
                    } catch (IOException ex) {
                        logger.warning("ERROR - "+ex.getMessage());
                    }
                    logger.info("----------send-msg----------");
                }
            }
            btn.addActionListener(new ButtonListener(textField.getText()));
            frame.add(btn);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                    try {
                        socket_accept.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            //-----------------------------------------------------------
        }
        catch(IOException e){
            logger.warning("ERROR - " + e.getMessage());
        }
        catch (Exception ex){
            logger.warning("ERROR - " + ex.getMessage());
        }
    }
}
