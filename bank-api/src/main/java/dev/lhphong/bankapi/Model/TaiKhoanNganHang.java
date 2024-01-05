package dev.lhphong.bankapi.Model;

import java.sql.Date;

public class TaiKhoanNganHang {
    private int tknhID;
    private String loaiTaiKhoan;
    private long soTaiKhoan;
    private String loaiTien;
    private long soDu;
    private Date ngayMo;
    private int ttcnID;

    public TaiKhoanNganHang() {
    }

    public TaiKhoanNganHang(String loaiTaiKhoan, long soTaiKhoan, String loaiTien, long soDu, Date ngayMo, int ttcnID) {
        this.loaiTaiKhoan = loaiTaiKhoan;
        this.soTaiKhoan = soTaiKhoan;
        this.loaiTien = loaiTien;
        this.soDu = soDu;
        this.ngayMo = ngayMo;
        this.ttcnID = ttcnID;
    }
}
