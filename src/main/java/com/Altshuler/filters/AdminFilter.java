package com.Altshuler.filters;

import com.Altshuler.info.ProjectInfo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/adminServlet")
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        if ((req.getParameter("login").equals(ProjectInfo.getAdminLogin())) &&
                (req.getParameter("password").equals(ProjectInfo.getAdminPassword())))
            filterChain.doFilter(req, resp);
        else resp.sendRedirect(contextPath + "/wrongData.jsp");

    }

}
