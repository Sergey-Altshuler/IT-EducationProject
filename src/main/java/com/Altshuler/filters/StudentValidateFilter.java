package com.Altshuler.filters;

import com.Altshuler.servletService.StudentServletService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/studentServlet")
public class StudentValidateFilter implements Filter {
    StudentServletService studentServletService = new StudentServletService();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();

        if (studentServletService.validate(req.getParameter("login"), req.getParameter("password"))) {
            studentServletService.logIn(req.getParameter("login"), req.getParameter("password"));
            filterChain.doFilter(req, resp);
        } else resp.sendRedirect(contextPath + "/wrongData.jsp");
    }
}
