package dev.lhphong.bankapi.Model;

public class NganHang {
    private int nganHangID;
    private String tenNganHang;
    private String chiNhanh;

    public NganHang() {
    }

    public NganHang(String tenNganHang, String chiNhanh) {
        this.tenNganHang = tenNganHang;
        this.chiNhanh = chiNhanh;
    }

    public int getNganHangID() {
        return nganHangID;
    }

    public void setNganHangID(int nganHangID) {
        this.nganHangID = nganHangID;
    }

    public String getTenNganHang() {
        return tenNganHang;
    }

    public void setTenNganHang(String tenNganHang) {
        this.tenNganHang = tenNganHang;
    }

    public String getChiNhanh() {
        return chiNhanh;
    }

    public void setChiNhanh(String chiNhanh) {
        this.chiNhanh = chiNhanh;
    }
}
