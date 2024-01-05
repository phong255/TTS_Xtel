package dev.lhphong.bankapi.Mapper;

import dev.lhphong.bankapi.DTO.TaiKhoanDTO;
import dev.lhphong.bankapi.Model.TaiKhoan;

public class TaiKhoanMapper {
    private static TaiKhoanMapper instance;
    private TaiKhoanMapper(){}
    public static TaiKhoanMapper getInstance(){
        if(instance == null)
            instance = new TaiKhoanMapper();
        return instance;
    }
//    public TaiKhoanDTO toDTO(TaiKhoan taiKhoan, )
}
