package dev.lhphong.bankapi.Controller.admin;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {

    private String message;
    public void setMessage(String message){
        this.message = message;
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Welcome to admin.</h1>");
        out.println("<h3 style="+"'color:red;'>Welcome to admin.</h3>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}