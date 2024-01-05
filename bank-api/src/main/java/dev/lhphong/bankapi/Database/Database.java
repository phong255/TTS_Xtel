package dev.lhphong.bankapi.Database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private static final Logger log = LoggerFactory.getLogger(Database.class);
    private static Database instance;
    private Database(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static Database getInstance() {
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection(){
        Properties props = new Properties();
        Connection connection = null;
        try {
            props.load(new InputStreamReader(new FileInputStream("database.properties")));
            String url = props.getProperty("DATABASE.URL");
            String username = props.getProperty("DATABASE.USERNAME");
            String password = props.getProperty("DATABASE.PASSWORD");
            connection = DriverManager.getConnection(url,username,password);
        } catch (IOException e) {
            log.error("Loi doc file config database + {}",e);
        } catch (SQLException e) {
            log.error("Loi ket noi database {}",e);
        }
        return connection;
    }
}
