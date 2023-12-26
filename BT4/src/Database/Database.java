package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database{
    private String url = "jdbc:mysql://localhost:3306/ttsxtel";
    private String username = "root";
    private String password = "";


    public Connection getConnect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Khai báo driver jdbc
        Connection connection = DriverManager.getConnection(url,username,password); //Tạo kết nối đến DB
        return connection;
    }
}
