package com.Altshuler.servlets;

import com.Altshuler.servlce.AdminServletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminChangePropertiesServlet")
public class AdminChangePropertiesServlet extends HttpServlet {
    private final AdminServletService adminServletService = new AdminServletService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        adminServletService.changeProperties(request.getParameter("login"), request.getParameter("password"));
        request.setAttribute("login", request.getParameter("login"));
        request.setAttribute("password", request.getParameter("password"));
        request.getRequestDispatcher("/adminSuccessChange.jsp").forward(request, response);
    }
}
