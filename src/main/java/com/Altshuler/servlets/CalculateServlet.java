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

import static com.Altshuler.info.ProjectAttributeConstants.ATTR_STATS;
import static com.Altshuler.info.ProjectPageConstants.PAGE_COACH_DISPLAY_STATS;

@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {
    private final MarkUtil markUtil = new MarkUtil();
    private final StatsServletService statsServletService = new StatsServletService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        markUtil.calculateIndividualStatistics(ProjectInfo.getCourse());
        markUtil.calculateTotalStatistics(ProjectInfo.getCourse());
        request.setAttribute(ATTR_STATS, statsServletService.getAll());
        request.getRequestDispatcher(PAGE_COACH_DISPLAY_STATS).forward(request, response);
    }
}
