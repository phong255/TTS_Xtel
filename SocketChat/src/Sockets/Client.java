package Sockets;

import java.io.*;
import java.net.Socket;


public class Client{
    Socket socket;
    DataOutputStream dataOutputStream;
    BufferedReader bufferedReader;
    public Client(String host,int port) throws IOException {
        socket = new Socket(host,port);
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }
    public String getInfo(){
        return socket.getInetAddress().getHostAddress() + " - " + socket.getPort();
    }
    public String getMessage() throws IOException {
        return bufferedReader.readLine();
    }

    public void sendMessage(String message) throws IOException {
        dataOutputStream.writeBytes(message);
        dataOutputStream.flush();
    }

    public void close() throws IOException {
        this.socket.close();
    }
}

