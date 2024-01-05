package dev.lhphong.bankapi.DAO;

import dev.lhphong.bankapi.Database.Database;
import dev.lhphong.bankapi.Model.Role;
import dev.lhphong.bankapi.Model.TaiKhoan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaiKhoanRoleDAO {
    private static final Logger log = LoggerFactory.getLogger(TaiKhoanRoleDAO.class);
    Database databse = Database.getInstance();
    private static TaiKhoanRoleDAO instance;
    private TaiKhoanRoleDAO(){}
    public static TaiKhoanRoleDAO getInstance(){
        if (instance == null)
            instance = new TaiKhoanRoleDAO();
        return instance;
    }

    public List<Integer> getRoleByTaiKhoanID(int taiKhoanID){
        Connection connection = databse.getConnection();
        List<Integer> roles = new ArrayList<>();
        StringBuilder query = null;
                query.append("select * from taikhoan ");
                query.append("inner join taikhoanrole");
                query.append("on taikhoan.taiKhoanID = taikhoanrole.taiKhoanID");
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                roles.add(Integer.parseInt(resultSet.getString("roleID").trim()));
            }
        }
        catch (SQLException e){
            log.error("Loi truy xuat database! {}",e);
        }
        return roles;
    }
}
