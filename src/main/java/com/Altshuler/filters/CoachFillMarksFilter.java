package com.Altshuler.filters;

import com.Altshuler.info.ProjectInfo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(urlPatterns = "/coachFillMarksServlet")
public class CoachFillMarksFilter implements Filter {
    private final String regex = "[0-9]|10|N";

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        Enumeration<String> params = req.getParameterNames();
        boolean areRightParams = true;
        while (params.hasMoreElements()) {
            String param = params.nextElement();
            if (!param.equals("numLesson")) {
                if (!req.getParameter(param).matches(regex)) {
                    areRightParams = false;
                }
            } else {
                int numLesson = Integer.parseInt(req.getParameter("numLesson"));
                if ((numLesson < 0) || (numLesson > ProjectInfo.getCourse().getNumOfLessons())) {
                    areRightParams = false;
                }
            }
        }
        if (areRightParams)
            filterChain.doFilter(req, resp);
        else resp.sendRedirect(contextPath + "/wrongOperation.jsp");

    }
}
