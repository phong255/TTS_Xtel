package Database;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final Logger log = Logger.getLogger(Database.class);
    private String url = "jdbc:mysql://localhost:3306/ttsxtel";
    private String username = "root";
    private String password = "";

    private static volatile Database instance;

    private Database() {
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // Khai báo driver jdbc
            Connection connection = DriverManager.getConnection(url, username, password); //Tạo kết nối đến DB
            return connection;
        }
        catch (ClassNotFoundException exception){
            if(log.isEnabledFor(Level.ERROR))
                log.error(exception);
            return null;
        }
        catch (SQLException ex){
            if(log.isEnabledFor(Level.ERROR))
                log.error(ex);
            return null;
        }
    }
}
