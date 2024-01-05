package dev.lhphong.bankapi.Service;

import dev.lhphong.bankapi.DAO.TaiKhoanRoleDAO;
import dev.lhphong.bankapi.Model.TaiKhoan;
import dev.lhphong.bankapi.DAO.TaiKhoanDAO;
import dev.lhphong.bankapi.DTO.TaiKhoanDTO;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

public class TaiKhoanService {
    private static final Logger log = LoggerFactory.getLogger(TaiKhoanService.class);
    private static TaiKhoanService instance;
    private TaiKhoanService(){}
    public static TaiKhoanService getInstance(){
        if(instance == null)
            instance = new TaiKhoanService();
        return instance;
    }
    TaiKhoanDAO taiKhoanDAO = TaiKhoanDAO.getInstance();
    TaiKhoanRoleDAO taiKhoanRoleDAO = TaiKhoanRoleDAO.getInstance();
    public TaiKhoanDTO getByUsername(String username){
        TaiKhoan taiKhoan = taiKhoanDAO.getByUsername(username);
        TaiKhoanDTO taiKhoanDTO = null;
        if (taiKhoan == null){
            log.error("Không tìm thấy tài khoản!");
            taiKhoanDTO = new TaiKhoanDTO(null,null,null,"Tài khoản không đúng","ERROR");
        }
        else {
            List<Integer> roles = taiKhoanRoleDAO.getRoleByTaiKhoanID(taiKhoan.getTaiKhoanID());
            taiKhoanDTO = new TaiKhoanDTO(taiKhoan.getTenTaiKhoan(),taiKhoan.getMatKhau(),roles,"Thành công","OK");
        }
        return taiKhoanDTO;
    }
}
