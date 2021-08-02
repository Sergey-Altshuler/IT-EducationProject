package com.Altshuler.servlets;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.servlce.StatsService;
import com.Altshuler.servlce.StatsServiceImpl;
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
    private final StatsService statsService = new StatsServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        markUtil.calculateIndividualStatistics(ProjectInfo.getCourse());
        markUtil.calculateTotalStatistics(ProjectInfo.getCourse());
       // request.setAttribute(ATTR_STATS, statsService.getAll());
        request.getRequestDispatcher("/coachMarksRedirect.jsp").forward(request, response);
    }
}
