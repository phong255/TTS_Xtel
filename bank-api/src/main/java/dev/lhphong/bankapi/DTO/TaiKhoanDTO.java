package dev.lhphong.bankapi.DTO;

import dev.lhphong.bankapi.Model.Role;

import java.io.Serializable;
import java.util.List;

public class TaiKhoanDTO implements Serializable {
    private String tenTaiKhoan;
    private String password;
    private List<Integer> roles;

    private String message;
    private String status;

    public TaiKhoanDTO(){}

    public TaiKhoanDTO(String tenTaiKhoan, String password, List<Integer> roles) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.password = password;
        this.roles = roles;
    }

    public TaiKhoanDTO(String tenTaiKhoan, String password, List<Integer> roles, String message, String status) {
        this.tenTaiKhoan = tenTaiKhoan;
        this.password = password;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }
}
