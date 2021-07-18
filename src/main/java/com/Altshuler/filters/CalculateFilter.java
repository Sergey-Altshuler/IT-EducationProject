package com.Altshuler.filters;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.util.MarkUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/calculateServlet")
public class CalculateFilter implements Filter {
    MarkUtil markUtil = new MarkUtil();
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        if (markUtil.getIsFinished(ProjectInfo.getCourse()) == 0 && (ProjectInfo.getCourse().getStats()==null))
            filterChain.doFilter(req, resp);
        else resp.sendRedirect(contextPath + "/wrongOperation.jsp");

    }
}
