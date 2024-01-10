package dev.lhphong.bankapi.Controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.lhphong.bankapi.Service.TaiKhoanService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "taiKhoanServlet", value = "/admin-tai-khoan")
public class TaiKhoanServlet extends HttpServlet {
    TaiKhoanService taiKhoanService = TaiKhoanService.getInstance();

    @Override //------all---------
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        OutputStream outputStream = resp.getOutputStream();
        outputStream.write(mapper.writeValueAsString(taiKhoanService.getAllTaiKhoan()).getBytes());
    }

    @Override //-------add---------
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override //-------update-------
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override //--------xoa---------
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);

    }
}
