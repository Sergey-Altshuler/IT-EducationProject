package com.Altshuler.filters;

import com.Altshuler.servletService.CoachServletService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/coachServlet")
public class CoachValidateFilter implements Filter {
   CoachServletService coachServletService = new CoachServletService();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        if (coachServletService.validate(req.getParameter("login"), req.getParameter("password"))) {
            coachServletService.logIn(req.getParameter("login"), req.getParameter("password"));
            filterChain.doFilter(req, resp);
        }
        else resp.sendRedirect(contextPath + "/wrongData.jsp");
    }
}
