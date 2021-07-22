package com.Altshuler.filters;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Course;
import com.Altshuler.servlce.CourseServletService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/coachPutMarksServlet")
public class CoachPutMarksFilter implements Filter {
    CourseServletService courseServletService = new CourseServletService();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();

        Course course = courseServletService.getById(Integer.parseInt(req.getParameter("number")));
        if (("Yes").equals(course.getIsStarted()) && ((ProjectInfo.getCoach()).equals(course.getCoach()))) {
            filterChain.doFilter(req, resp);
        } else resp.sendRedirect(contextPath + "/wrongOperation.jsp");
    }

}

