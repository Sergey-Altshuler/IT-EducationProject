package com.Altshuler.filters;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Coach;
import com.Altshuler.model.Course;
import com.Altshuler.service.Manager;
import lombok.SneakyThrows;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = "/coachChooseCourseServlet")
public class CoachChooseCourseFilter implements Filter {
    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();

        Course course = Manager.getCourseById(Integer.parseInt(req.getParameter("number")));

        if (course.getCoachRequired().equals("Yes")){
            course.setCoachRequired("No");
            filterChain.doFilter(req, resp);
        }
        else resp.sendRedirect(contextPath + "/coachIsNotRequired.jsp");

    }
}
