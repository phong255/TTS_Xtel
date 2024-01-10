package dev.lhphong.bankapi.Service;

import com.github.benmanes.caffeine.cache.Cache;
import dev.lhphong.bankapi.CacheConfig.BankCache;
import dev.lhphong.bankapi.Constant.RoleConstant;
import dev.lhphong.bankapi.DAO.TaiKhoanRoleDAO;
import dev.lhphong.bankapi.Model.Role;
import dev.lhphong.bankapi.Model.TaiKhoan;
import dev.lhphong.bankapi.DAO.TaiKhoanDAO;
import dev.lhphong.bankapi.DTO.TaiKhoanDTO;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaiKhoanService {
    private static final Logger log = LoggerFactory.getLogger(TaiKhoanService.class);
    private static TaiKhoanService instance;

    private Cache<String,Object> cache = BankCache.getInstance();
    private TaiKhoanService(){}
    public static TaiKhoanService getInstance(){
        if(instance == null)
            instance = new TaiKhoanService();
        return instance;
    }
    TaiKhoanDAO taiKhoanDAO = TaiKhoanDAO.getInstance();
    TaiKhoanRoleDAO taiKhoanRoleDAO = TaiKhoanRoleDAO.getInstance();
    public static  boolean isAdmin(TaiKhoanDTO taiKhoanDTO){
        if(taiKhoanDTO.getRoles().contains(RoleConstant.ADMIN_EMPLOYEE) || taiKhoanDTO.getRoles().contains(RoleConstant.ADMIN_MANAGER))
            return true;
        return false;
    }

    public static  boolean isAdminEmp(TaiKhoanDTO taiKhoanDTO){
        if(taiKhoanDTO.getRoles().contains(RoleConstant.ADMIN_EMPLOYEE))
            return true;
        return false;
    }
    public static  boolean isAdminMng(TaiKhoanDTO taiKhoanDTO){
        if(taiKhoanDTO.getRoles().contains(RoleConstant.ADMIN_MANAGER))
            return true;
        return false;
    }
    public static  boolean isClient(TaiKhoanDTO taiKhoanDTO){
        if(taiKhoanDTO.getRoles().contains(RoleConstant.ADMIN_CLIENT))
            return true;
        return false;
    }
    public boolean checkEquals(String tenTaiKhoan,String matKhau,TaiKhoanDTO taiKhoanDTO){
        if(tenTaiKhoan.compareTo(taiKhoanDTO.getTenTaiKhoan()) == 0 && matKhau.compareTo(taiKhoanDTO.getMatKhau()) == 0)
            return true;
        return false;
    }

    public TaiKhoanDTO getByUsername(String username){
        TaiKhoan taiKhoan = taiKhoanDAO.getByUsername(username);
        TaiKhoanDTO taiKhoanDTO = null;
        if (taiKhoan == null){
            log.error("Khong tim thay tai khoan!");
            taiKhoanDTO = new TaiKhoanDTO(null,null,null,"Tai khoan khong chinh xac!", HttpServletResponse.SC_UNAUTHORIZED);
        }
        else {
            List<Integer> roles = taiKhoanRoleDAO.getRoleByTaiKhoanID(taiKhoan.getTaiKhoanID());
            List<Integer> roles_backup = new ArrayList<>();
            roles_backup.add(0);
            taiKhoanDTO = new TaiKhoanDTO(taiKhoan.getTenTaiKhoan(),taiKhoan.getMatKhau(),roles == null ? roles_backup : roles,"Success",HttpServletResponse.SC_OK);
        }
        return taiKhoanDTO;
    }

    public List<TaiKhoanDTO> getAllTaiKhoan(){
        List<TaiKhoanDTO> taiKhoanDTOS = new ArrayList<>();
        List<TaiKhoan> taiKhoans = taiKhoanDAO.getAllTaiKhoan();
        for (TaiKhoan t : taiKhoans){
            List<Integer> roles = taiKhoanRoleDAO.getRoleByTaiKhoanID(t.getTaiKhoanID());
            taiKhoanDTOS.add(new TaiKhoanDTO(t.getTenTaiKhoan(),t.getMatKhau(),roles,"Success",HttpServletResponse.SC_OK));
        }
        return taiKhoanDTOS;
    }
}
