package com.Altshuler.servlets;

import com.Altshuler.servletService.StatsServletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminDisplayStatsServlet")
public class AdminDisplayStatsServlet extends HttpServlet {
    StatsServletService statsServletService = new StatsServletService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("stats", statsServletService.getAll());
        request.getRequestDispatcher("/adminDisplayStats.jsp").forward(request, response);
    }
}
