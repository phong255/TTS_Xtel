package Services;

import java.sql.*;
import Database.Database;

public class Service {
    Database database = Database.getInstance();
    private static Service instance;

    public Service(){};
    public static Service getInstance(){
        if(instance == null){
            instance = new Service();
        }
        return instance;
    }

    //Ham truy van lay tat ca ban ghi trong bang table
    public  ResultSet getAll(String table) throws SQLException{
        StringBuilder query = new StringBuilder();
        query.append("select * from ").append(table);
        Connection connection = database.getConnect();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query.toString());
        return rs;
    }

    //Dong ket noi voi database
    public void close() throws SQLException{
        database.getConnect().close();
    }
}
