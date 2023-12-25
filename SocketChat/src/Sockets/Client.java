package Sockets;

import java.io.*;
import java.net.Socket;


public class Client{
    Socket socket;
    DataOutputStream dataOutputStream;
    BufferedReader bufferedReader;

    //Tạo socket máy khách yêu cầu kết nối đến server
    public Client(String host,int port) throws IOException {
        socket = new Socket(host,port);
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

    // Lấy thông tin socket máy khách
    public String getInfo(){
        return socket.getInetAddress().getHostAddress() + " - " + socket.getPort();
    }
    //Đọc tin nhắn server gửi đến
    public String getMessage() throws IOException {
        return bufferedReader.readLine();
    }
    //Gửi tin nhắn đến server
    public void sendMessage(String message) throws IOException {
        dataOutputStream.writeBytes(message);
        dataOutputStream.flush();
    }
    //Đóng kết nối của socket máy khách
    public void close() throws IOException {
        this.socket.close();
    }
}

