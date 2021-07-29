package com.Altshuler.servlets;

import com.Altshuler.servlce.StatsServletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.Altshuler.info.ProjectAttributeConstants.ATTR_STATS;
import static com.Altshuler.info.ProjectPageConstants.PAGE_ADMIN_DISPLAY_STATS;

@WebServlet("/adminDisplayStats")
public class AdminDisplayStatsServlet extends HttpServlet {
    private final StatsServletService statsServletService = new StatsServletService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute(ATTR_STATS, statsServletService.getAll());
        request.getRequestDispatcher(PAGE_ADMIN_DISPLAY_STATS).forward(request, response);
    }
}
