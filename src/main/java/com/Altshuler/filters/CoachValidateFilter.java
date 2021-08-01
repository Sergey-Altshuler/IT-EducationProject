package com.Altshuler.filters;

import com.Altshuler.servlce.CoachService;
import com.Altshuler.servlce.CoachServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.Altshuler.info.ProjectPageConstants.PAGE_WRONG_DATA;
import static com.Altshuler.info.ProjectParamConstants.PARAM_LOGIN;
import static com.Altshuler.info.ProjectParamConstants.PARAM_PASSWORD;

@WebFilter(urlPatterns = "/coach")
public class CoachValidateFilter implements Filter {
    private final CoachService coachService = new CoachServiceImpl();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        if ((req.getParameter(PARAM_LOGIN) == null) && (req.getParameter(PARAM_PASSWORD) == null))
            filterChain.doFilter(req, resp);
        else {
            if (coachService.validate(req.getParameter(PARAM_LOGIN), req.getParameter(PARAM_PASSWORD))) {
                coachService.logIn(req.getParameter(PARAM_LOGIN), req.getParameter(PARAM_PASSWORD));
                filterChain.doFilter(req, resp);
            } else resp.sendRedirect(contextPath + PAGE_WRONG_DATA);
        }
    }
}
