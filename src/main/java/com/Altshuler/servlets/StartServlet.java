package com.Altshuler.servlets;

import com.Altshuler.servlce.AdminServletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/startServlet")
public class StartServlet extends HttpServlet {
    private final AdminServletService adminServletService = new AdminServletService();

    public void init() {
        adminServletService.initialize();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/welcome.jsp").forward(request, response);
    }
}