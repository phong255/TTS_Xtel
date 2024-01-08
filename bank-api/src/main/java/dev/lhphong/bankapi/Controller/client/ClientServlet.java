package dev.lhphong.bankapi.Controller.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.lhphong.bankapi.DTO.TaiKhoanDTO;
import dev.lhphong.bankapi.Service.TaiKhoanService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "clientServlet", value = "/api-client")
public class ClientServlet extends HttpServlet {
    TaiKhoanService taiKhoanService = TaiKhoanService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String username = req.getParameter("tenTaiKhoan");
        TaiKhoanDTO taiKhoanDTO = taiKhoanService.getByUsername(username);
        resp.setStatus(HttpServletResponse.SC_OK);
        OutputStream outputStream = resp.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        outputStream.write(mapper.writeValueAsString(taiKhoanDTO).getBytes());
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
