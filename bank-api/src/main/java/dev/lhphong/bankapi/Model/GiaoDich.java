package dev.lhphong.bankapi.Model;

import java.sql.Date;

public class GiaoDich {
    private int giaoDichID;
    private String maGiaoDich;
    private String taiKhoanNhan;
    private String nganHangNhan;
    private Date thoiGian;
    private String noiDung;
    private long phGiaoDich;
    private int tknhID;

    public GiaoDich() {
    }

    public GiaoDich(String maGiaoDich, String taiKhoanNhan, String nganHangNhan, Date thoiGian, String noiDung, long phGiaoDich, int tknhID) {
        this.maGiaoDich = maGiaoDich;
        this.taiKhoanNhan = taiKhoanNhan;
        this.nganHangNhan = nganHangNhan;
        this.thoiGian = thoiGian;
        this.noiDung = noiDung;
        this.phGiaoDich = phGiaoDich;
        this.tknhID = tknhID;
    }

    public int getGiaoDichID() {
        return giaoDichID;
    }

    public void setGiaoDichID(int giaoDichID) {
        this.giaoDichID = giaoDichID;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public String getTaiKhoanNhan() {
        return taiKhoanNhan;
    }

    public void setTaiKhoanNhan(String taiKhoanNhan) {
        this.taiKhoanNhan = taiKhoanNhan;
    }

    public String getNganHangNhan() {
        return nganHangNhan;
    }

    public void setNganHangNhan(String nganHangNhan) {
        this.nganHangNhan = nganHangNhan;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public long getPhGiaoDich() {
        return phGiaoDich;
    }

    public void setPhGiaoDich(long phGiaoDich) {
        this.phGiaoDich = phGiaoDich;
    }

    public int getTknhID() {
        return tknhID;
    }

    public void setTknhID(int tknhID) {
        this.tknhID = tknhID;
    }
}
