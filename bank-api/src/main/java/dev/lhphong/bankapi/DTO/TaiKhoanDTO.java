package dev.lhphong.bankapi.DTO;

import dev.lhphong.bankapi.Model.Role;
import dev.lhphong.bankapi.Model.TaiKhoan;

import java.io.Serializable;
import java.util.List;

public class TaiKhoanDTO implements Serializable {
    private String tenTaiKhoan;
    private String matKhau;
    private List<Integer> roles;

    private String message;
    private int status;

    public TaiKhoanDTO(){}

    public TaiKhoanDTO(String tenTaiKhoan, String matKhau, List<Integer> roles) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.roles = roles;
    }

    public TaiKhoanDTO(String tenTaiKhoan, String matKhau, List<Integer> roles, String message, int status) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.matKhau = matKhau;
        this.roles = roles;
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }
}
