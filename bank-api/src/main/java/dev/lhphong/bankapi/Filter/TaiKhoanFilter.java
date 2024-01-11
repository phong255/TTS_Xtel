package dev.lhphong.bankapi.Filter;

import dev.lhphong.bankapi.Constant.RoleConstant;
import dev.lhphong.bankapi.DTO.TaiKhoanDTO;
import dev.lhphong.bankapi.Security.HttpBasicAuth;
import dev.lhphong.bankapi.Service.TaiKhoanService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TaiKhoanFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(TaiKhoanFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getServletPath();
        if(path.contains("/admin-tai-khoan")){
            String auth = request.getHeader("Authorization");
            //Kiem tra ma xac thuc
            if(auth == null || HttpBasicAuth.Authorization == null){
                unauthorized(response);
            }
            else if (!auth.toUpperCase().startsWith("BASIC ") || auth.compareToIgnoreCase(HttpBasicAuth.Authorization) != 0) {
                unauthorized(response);
            }
            //Kiem tra tai khoan
            else if(HttpBasicAuth.isAuthorization(auth)){
                filterChain.doFilter(servletRequest,servletResponse);
            }
            else{
                unauthorized(response);
            }
        }

    }

    public void unauthorized(HttpServletResponse response) throws IOException {
        log.error("401 - Unauthorized");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getOutputStream().write("Unauthorized!".getBytes());
    }
}
