package com.Altshuler.filters;

import com.Altshuler.model.Course;
import com.Altshuler.servlce.CourseService;
import com.Altshuler.servlce.CourseServiceImpl;
import com.mysql.cj.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.Altshuler.info.ProjectNamedConstants.NO;
import static com.Altshuler.info.ProjectPageConstants.PAGE_WRONG_OPERATION;
import static com.Altshuler.info.ProjectParamConstants.PARAM_LAUNCH_ID;

@WebFilter(urlPatterns = "/adminLaunchCourse")
public class AdminLaunchCourseServletFilter implements Filter {
    private final CourseService courseService = new CourseServiceImpl();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();

        if (StringUtils.isNullOrEmpty(req.getParameter(PARAM_LAUNCH_ID))) filterChain.doFilter(req, resp);
        else {
            Course course = courseService.getById(Integer.parseInt(req.getParameter(PARAM_LAUNCH_ID)));
            if((!StringUtils.isNullOrEmpty(course.getCoachRequired()))&& ((course.getRemaining() == 0) && (course.getCoachRequired().equals(NO)))) {
                filterChain.doFilter(req, resp);
            } else {
                resp.sendRedirect(contextPath + PAGE_WRONG_OPERATION);
            }
        }
    }

}

