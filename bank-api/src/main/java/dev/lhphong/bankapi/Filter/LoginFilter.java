package dev.lhphong.bankapi.Filter;

import dev.lhphong.bankapi.DTO.TaiKhoanDTO;
import dev.lhphong.bankapi.Mapper.HttpUtil;
import dev.lhphong.bankapi.Security.TokenJWTUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;

public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
