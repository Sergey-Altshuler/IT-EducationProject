package com.Altshuler.filters;

import com.Altshuler.model.Course;
import com.Altshuler.servletService.CourseServletService;
import com.Altshuler.servletService.StudentServletService;
import com.Altshuler.util.HQLUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/studentChooseCourseServlet")
public class StudentChooseCourseFilter implements Filter {
    private final HQLUtil hqlUtil = new HQLUtil();
    CourseServletService courseServletService = new CourseServletService();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();

        boolean isCurrentCourse = hqlUtil.checkCourseById(Integer.parseInt(req.getParameter("number")));
        if (isCurrentCourse) {
            Course course = courseServletService.getById(Integer.parseInt(req.getParameter("number")));
            if (course.getRemaining()>0) {
                course.setRemaining(course.getRemaining()-1);
                courseServletService.add(course);
                filterChain.doFilter(req, resp);
            } else resp.sendRedirect(contextPath + "/wrongOperation.jsp");
        } else resp.sendRedirect(contextPath + "/wrongOperation.jsp");
    }
}
