package dev.lhphong.bankapi.DAO;

import dev.lhphong.bankapi.Database.Database;
import dev.lhphong.bankapi.Model.TaiKhoan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanDAO {
    private static final Logger log = LoggerFactory.getLogger(TaiKhoanDAO.class);
    Database database = Database.getInstance();

    private static TaiKhoanDAO instance;
    private TaiKhoanDAO(){}
    public static TaiKhoanDAO getInstance(){
        if(instance == null){
            instance = new TaiKhoanDAO();
        }
        return instance;
    }

    public List<TaiKhoan> getAllTaiKhoan(){
        Connection connection = database.getConnection();
        List<TaiKhoan> taikhoans = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from taikhoan");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int taiKhoanID = Integer.parseInt(rs.getString("taiKhoanID").trim());
                String tenTaiKhoan = rs.getString("tenTaiKhoan");
                String matKhau = rs.getString("matKhau");
                TaiKhoan taiKhoan = new TaiKhoan(taiKhoanID,tenTaiKhoan,matKhau);
                taikhoans.add(taiKhoan);
            }
            connection.close();
        }
        catch(SQLException e){
            log.error("Loi truy xuat du lieu!",e);
        }
        return taikhoans;
    }

    public TaiKhoan getByUsername(String username){
        Connection connection = database.getConnection();
        TaiKhoan taiKhoan = null;
        StringBuilder query = new StringBuilder("select * from taikhoan where tenTaiKhoan = '")
        //Cau truy van
                .append(username + "'");
        try{
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from taikhoan where tenTaiKhoan = 'user1'");
//            ResultSet rs = preparedStatement.executeQuery();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query.toString());
            while(rs.next()){
                int taiKhoanID = Integer.parseInt(rs.getString("taiKhoanID").trim());
                String tenTaiKhoan = rs.getString("tenTaiKhoan");
                String matKhau = rs.getString("matKhau");
                taiKhoan = new TaiKhoan(taiKhoanID,tenTaiKhoan,matKhau);
            }
            connection.close();
        }
        catch(SQLException e){
            log.error("Loi truy xuat du lieu!",e);
        }
        return taiKhoan;
    }
}
