package dev.lhphong.bankapi.DAO;

import dev.lhphong.bankapi.Database.Database;

public class RoleDAO{
    Database databse = Database.getInstance();
    private static RoleDAO instance;
    private RoleDAO(){}
    public static RoleDAO getInstance(){
        if (instance == null)
            instance = new RoleDAO();
        return instance;
    }

}
