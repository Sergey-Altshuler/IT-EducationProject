package com.Altshuler.filters;

import com.Altshuler.util.HQLUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/adminDropCourseServlet")
public class AdminDropCourseServletFilter implements Filter {
   private final HQLUtil hqlUtil = new HQLUtil();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        if (hqlUtil.checkCourseById(Integer.parseInt(req.getParameter("number"))))  filterChain.doFilter(req, resp);
        else resp.sendRedirect(contextPath + "/wrongOperation.jsp");

    }
}
