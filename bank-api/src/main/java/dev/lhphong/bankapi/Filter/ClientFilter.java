package dev.lhphong.bankapi.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ClientFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(ClientFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Khoi tao filter.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getServletPath();
        String contextPath = request.getContextPath();
        log.info(contextPath + " ----- " + path);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("Huy filter.");
    }
}
