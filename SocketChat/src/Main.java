
import ThreadChats.ClientThread;
import UIChats.UIClient;
import UIChats.UIServer;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Dashboard");
        frame.setSize(500, 700);
        JLabel label = new JLabel("Host:");
        label.setBounds(10, 10,260,30);
        frame.add(label);
        JTextField textField = new JTextField();
        textField.setBounds(10, 50, 450, 30);
        frame.add(textField);
        JLabel label1 = new JLabel("Port:");
        label1.setBounds(10, 100,260,30);
        frame.add(label1);
        JTextField port = new JTextField();
        port.setBounds(10, 150, 450, 30);
        frame.add(port);
        JButton btnServer = new JButton("Create server");
        btnServer.setBounds(100, 200, 300, 40);
        JButton btnClient = new JButton("Create client");
        btnClient.setBounds(100, 250, 300, 40);
        class ButtonServerListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIServer uiServer = new UIServer();
                try{
                    uiServer.init(Integer.parseInt(port.getText().trim()));
                }
                catch (IOException ex){
                    logger.error(ex.getMessage(),ex.getCause());
                }
            }
        }
        btnServer.addActionListener(new ButtonServerListener());
        frame.add(btnServer);
        class ButtonClientListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIClient uiClient = new UIClient();
                try{
                    uiClient.init(textField.getText(),Integer.parseInt(port.getText().trim()));
                }
                catch (IOException ex){
                    logger.error(ex.getMessage(),ex.getCause());
                }
            }
        }
        btnClient.addActionListener(new ButtonClientListener());
        frame.add(btnClient);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}