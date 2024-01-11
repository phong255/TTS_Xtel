package dev.lhphong.bankapi.Security;

import dev.lhphong.bankapi.DTO.TaiKhoanDTO;
import dev.lhphong.bankapi.Service.TaiKhoanService;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class HttpBasicAuth {
    static TaiKhoanService taiKhoanService = TaiKhoanService.getInstance();
    public static String Authorization; //Bien tinh de luu ma xac thuc

    //Encode ma xac thuc tu username va password
    public static String generate(String username,String password){
        StringBuilder encode =  new StringBuilder(username + ":" + password);
        return "BASIC " + Base64.getEncoder().encodeToString(encode.toString().getBytes());
    }

    public static boolean isAuthorization(String authorization){
        String username = null;
        String password = null;
        List<Integer> roles = new ArrayList<>();
        authorization = authorization.substring(5).trim();
        authorization = new String(Base64.getDecoder().decode(authorization));
        String[] auths = authorization.split(":");
        for(int i=0;i<auths.length;i++){
            if(i==0)
                username = auths[0];
            else if (i == 1)
                password = auths[1];
            else
                roles.add(Integer.parseInt(auths[i].trim()));
        }
        TaiKhoanDTO taiKhoanDTO = taiKhoanService.getByUsername(username);
        if(username.compareToIgnoreCase(taiKhoanDTO.getTenTaiKhoan())==0 && password.compareToIgnoreCase(taiKhoanDTO.getMatKhau())==0 && TaiKhoanService.isAdmin(taiKhoanDTO))
            return true;
        else
            return false;
    }
}
