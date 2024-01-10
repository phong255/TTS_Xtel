package dev.lhphong.bankapi.Controller.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.lhphong.bankapi.DTO.TaiKhoanDTO;
import dev.lhphong.bankapi.Mapper.HttpUtil;
import dev.lhphong.bankapi.Service.TaiKhoanService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
@WebServlet(name = "loginAdmin",value = "/admin")
public class LoginAdminServlet extends HttpServlet {
    TaiKhoanService taiKhoanService = TaiKhoanService.getInstance();
    //Login admin
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        OutputStream outputStream = resp.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        TaiKhoanDTO taiKhoanDTO = HttpUtil.of(req.getReader()).convertTo(TaiKhoanDTO.class);
        TaiKhoanDTO taiKhoanDTO_check = taiKhoanService.getByUsername(taiKhoanDTO.getTenTaiKhoan());
        if(!taiKhoanService.checkEquals(taiKhoanDTO.getTenTaiKhoan(),taiKhoanDTO.getMatKhau(),taiKhoanDTO_check)){
            taiKhoanDTO.setMessage("Tai khoan hoac mat khau khong chinh xac !");
            taiKhoanDTO.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            outputStream.write(mapper.writeValueAsString(taiKhoanDTO).getBytes());
        }
        else {
            taiKhoanDTO_check.setStatus(HttpServletResponse.SC_OK);
            outputStream.write(mapper.writeValueAsString(taiKhoanDTO_check).getBytes());
            //Tao session admin
            req.getSession().setAttribute("admin",taiKhoanDTO_check);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream outputStream = resp.getOutputStream();
        outputStream.write(new String("Welcome to admin!").getBytes());
    }
}
