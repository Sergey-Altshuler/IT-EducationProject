package com.Altshuler.filters;

import com.Altshuler.model.Course;
import com.Altshuler.servlce.CourseServletService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.Altshuler.info.ProjectNamedConstants.NO;
import static com.Altshuler.info.ProjectNamedConstants.YES;
import static com.Altshuler.info.ProjectPageConstants.PAGE_WRONG_OPERATION;
import static com.Altshuler.info.ProjectParamConstants.PARAM_NUMBER;

@WebFilter(urlPatterns = "/coachChooseCourse")
public class CoachChooseCourseFilter implements Filter {
    private final CourseServletService courseServletService = new CourseServletService();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        Course course = courseServletService.getById(Integer.parseInt(req.getParameter(PARAM_NUMBER)));
        if ((YES).equals(course.getCoachRequired())) {
            course.setCoachRequired(NO);
            courseServletService.add(course);
            filterChain.doFilter(req, resp);
        } else resp.sendRedirect(contextPath + PAGE_WRONG_OPERATION);

    }
}
