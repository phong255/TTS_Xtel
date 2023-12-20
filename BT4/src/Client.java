import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends Thread{
    final Logger logger = Logger.getLogger("Client");
    public Client(){
        this.start();
    }
    @Override
    public void run() {
        try {
            while (true){
                Socket socket = new Socket("127.0.0.1",2505);
                System.out.print("Input your command: ");
                String command = new Scanner(System.in).nextLine() + "\n";
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            System.out.println(br.read());
                dataOutputStream.writeBytes(command);
                logger.info("--------send-msg----------");
                System.out.println(br.readLine());
//                socket.close();
            }
            //-------chat box server------------------------------------
//            JFrame frame = new JFrame();
//            frame.setTitle(getName());
//            frame.setSize(300, 400);
//            JTextArea jTextArea = new JTextArea();
//            jTextArea.setBounds(10, 10, 260, 150);
//            jTextArea.setEditable(false);
//            frame.add(jTextArea);
//            JTextField textField = new JTextField();
//            textField.setBounds(10, 170, 260, 30);
//            frame.add(textField);
//            JButton btn = new JButton("Send");
//            btn.setBounds(100, 250, 100, 30);
//            dataOutputStream.writeBytes("Make connection");
////            String msg = br.readLine();
////            if(msg != null)
////                jTextArea.append(br.readLine() + "\n");
//            class ButtonListener implements ActionListener {
//                String send_msg;
//
//                public ButtonListener(String send_msg) {
//                    this.send_msg = send_msg;
//                }
//
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    send_msg = textField.getText();
//                    try {
//                        dataOutputStream.writeBytes(send_msg);
//                        logger.info("----------send----------");
//                    } catch (IOException ex) {
//                        logger.warning("ERROR - " + ex.getMessage());
//                    }
//                }
//            }
//            btn.addActionListener(new ButtonListener(textField.getText()));
//            frame.add(btn);
//            frame.addWindowListener(new WindowAdapter() {
//                @Override
//                public void windowClosing(WindowEvent e) {
//                    System.exit(0);
//                    try {
//                        socket.close();
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                }
//            });
//            frame.setLayout(null);
//            frame.setVisible(true);
//            while(true){
//                String msg = br.readLine();
//                if(msg != null)
//                    jTextArea.append(msg + "\n");
//            }
            //-----------------------------------------------------------
        } catch (UnknownHostException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
