package com.Altshuler.servlets;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.servlce.StatsServletService;
import com.Altshuler.util.MarkUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculateServlet")
public class CalculateServlet extends HttpServlet {
    MarkUtil markUtil = new MarkUtil();
    StatsServletService statsServletService = new StatsServletService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        markUtil.calculateIndividualStatistics(ProjectInfo.getCourse());
        markUtil.calculateTotalStatistics(ProjectInfo.getCourse());
        request.setAttribute("stats", statsServletService.getAll());
        request.getRequestDispatcher("/coachDisplayStats.jsp").forward(request, response);
    }
}
