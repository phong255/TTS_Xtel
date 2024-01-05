package dev.lhphong.bankapi.Model;

import java.sql.Date;

public class ThongTinCaNhan {
    private int ttcnID;
    private String hoTen;
    private int tuoi;
    private Date ngaySinh;
    private String soCCCD;
    private String email;
    private String diaChi;
    private int taiKhoanID;

    public ThongTinCaNhan(){}

    public ThongTinCaNhan(String hoTen, int tuoi, Date ngaySinh, String soCCCD, String email, String diaChi, int taiKhoanID) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.ngaySinh = ngaySinh;
        this.soCCCD = soCCCD;
        this.email = email;
        this.diaChi = diaChi;
        this.taiKhoanID = taiKhoanID;
    }

    public int getTtcnID() {
        return ttcnID;
    }

    public void setTtcnID(int ttcnID) {
        this.ttcnID = ttcnID;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoCCCD() {
        return soCCCD;
    }

    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTaiKhoanID() {
        return taiKhoanID;
    }

    public void setTaiKhoanID(int taiKhoanID) {
        this.taiKhoanID = taiKhoanID;
    }
}
