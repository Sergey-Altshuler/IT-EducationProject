package com.Altshuler.filters;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Coach;
import com.Altshuler.service.Manager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@WebFilter(urlPatterns = "/coachFillMarksServlet")
public class CoachMarksAbsenceFilter implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        Enumeration<String> params = req.getParameterNames();
        boolean areRightParams = true;
        while (params.hasMoreElements()) {
            String param = params.nextElement();
            if (!param.equals("numLesson")) {
                if (!req.getParameter(param).matches("[0-9]|10|N")) {
                    areRightParams = false;
                }
            }
        }
        if (areRightParams)
            filterChain.doFilter(req, resp);
        else resp.sendRedirect(contextPath + "/wrongData.jsp");

    }
}
