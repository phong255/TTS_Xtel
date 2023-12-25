package Sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    ServerSocket server;
    DataOutputStream dataOutputStream;
    BufferedReader bufferedReader;
    Socket socketAccept;
    //Khoi tao server socket
    public Server(int port) throws IOException {
        server = new ServerSocket(port);
    }
    //Tạo socket lắng nghe và đọc ghi dữ liệu đến socket máy khách
    public void getConnect() throws IOException {
        socketAccept = server.accept();
        bufferedReader = new BufferedReader(new InputStreamReader(socketAccept.getInputStream()));
        dataOutputStream = new DataOutputStream(socketAccept.getOutputStream());
    }
    //Lấy thông tin port của server socket
    public int getPort(){
        return server.getLocalPort();
    }
    public Socket getSocketAccept() {
        return socketAccept;
    }

    //Đọc tin nhắn từ socket lắng nghe nhận được
    public String getMessage() throws IOException {
        return bufferedReader.readLine();
    }

    //Gửi tin nhắn từ socket lắng nghe
    public void sendMessage(String message) throws IOException {
        dataOutputStream.writeBytes(message);
        dataOutputStream.flush();
    }

    //Đóng kết nốt của socket lắng nghe
    public void close() throws IOException {
        this.getSocketAccept().close();
    }
}
