package com.Altshuler.filters;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Course;
import com.Altshuler.service.Manager;
import lombok.SneakyThrows;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = "/adminDropCourseServlet")
public class AdminDropCourseServletFilter implements Filter {
    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        List<Course> courseList = Manager.getAllCourses();
        boolean isNumber = false;
        for (Course course: courseList){
            if (course.getId()==Integer.parseInt(req.getParameter("number"))){
                isNumber=true;
            }
        }
        if (isNumber)  filterChain.doFilter(req, resp);
        else resp.sendRedirect(contextPath + "/wrongOperation.jsp");

    }
}
