package com.Altshuler.filters;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Coach;
import com.Altshuler.model.Student;
import com.Altshuler.service.Manager;
import lombok.SneakyThrows;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = "/coachServlet")
public class CoachFilter implements Filter {
    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        List<Coach> coachList = Manager.getAllCoaches();
        boolean isCoach = false;
        for (Coach coach: coachList) {
            if ((req.getParameter("login").equals(coach.getLogin())) && (req.getParameter("password")).equals(coach.getPassword())) {
                {
                    isCoach = true;
                    ProjectInfo.setCoach(coach);
                }
            }
        }
        if (isCoach)
            filterChain.doFilter(req, resp);
        else resp.sendRedirect(contextPath + "/wrongData.jsp");

    }
}
