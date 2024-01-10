package dev.lhphong.bankapi.Filter;

import dev.lhphong.bankapi.DTO.TaiKhoanDTO;
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
        String path = request.getServletPath();
        if(path.contains("/admin-tai-khoan")){
            TaiKhoanDTO taiKhoanDTO = (TaiKhoanDTO) request.getSession().getAttribute("admin");
            if(taiKhoanDTO != null && TaiKhoanService.isAdmin(taiKhoanDTO)){
                filterChain.doFilter(servletRequest,servletResponse);
            }
            else{
                log.error("403 - Khong co tham quyen");
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.sendRedirect(request.getContextPath()+"/admin");
            }
        }

    }
}
