package com.Altshuler.filters;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Course;
import com.Altshuler.service.Manager;
import com.Altshuler.servletService.CourseServletService;
import com.Altshuler.util.HQLUtil;
import lombok.SneakyThrows;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Queue;

@WebFilter(urlPatterns = "/coachPutMarksServlet")
public class CoachPutMarksFilter implements Filter {
    HQLUtil hqlUtil = new HQLUtil();
    CourseServletService courseServletService = new CourseServletService();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();

        boolean isCurrentCourse = hqlUtil.checkCourseById(Integer.parseInt(req.getParameter("number")));
        if (isCurrentCourse) {
            Course course = courseServletService.getById(Integer.parseInt(req.getParameter("number")));
            if (("true").equals(course.getIsStarted())&&((ProjectInfo.getCoach()).equals(course.getCoach()))) {
                filterChain.doFilter(req, resp);
            } else resp.sendRedirect(contextPath + "/wrongOperation.jsp");
        } else resp.sendRedirect(contextPath + "/wrongOperation.jsp");

    }
}
