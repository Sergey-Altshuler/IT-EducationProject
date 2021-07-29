package com.Altshuler.filters;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.util.MarkUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.Altshuler.info.ProjectPageConstants.PAGE_WRONG_OPERATION;

@WebFilter(urlPatterns = "/calculate")
public class CalculateFilter implements Filter {
    private final MarkUtil markUtil = new MarkUtil();

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        if ((ProjectInfo.getCourse()!=null)&&(markUtil.getIsFinished(ProjectInfo.getCourse()) == 0 && (ProjectInfo.getCourse().getStats() == null)))
            filterChain.doFilter(req, resp);
        else resp.sendRedirect(contextPath + PAGE_WRONG_OPERATION);

    }
}
