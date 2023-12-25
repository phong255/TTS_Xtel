package Sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    ServerSocket server;
    DataOutputStream dataOutputStream;
    BufferedReader bufferedReader;
    Socket socketAccept;
    public Server(int port) throws IOException {
        server = new ServerSocket(port);
    }
    public void getConnect() throws IOException {
        socketAccept = server.accept();
        bufferedReader = new BufferedReader(new InputStreamReader(socketAccept.getInputStream()));
        dataOutputStream = new DataOutputStream(socketAccept.getOutputStream());
    }
    public int getPort(){
        return server.getLocalPort();
    }
    public Socket getSocketAccept() {
        return socketAccept;
    }

    public String getMessage() throws IOException {
        return bufferedReader.readLine();
    }
    public void sendMessage(String message) throws IOException {
        dataOutputStream.writeBytes(message);
        dataOutputStream.flush();
    }

    public void close() throws IOException {
        this.getSocketAccept().close();
    }
}
