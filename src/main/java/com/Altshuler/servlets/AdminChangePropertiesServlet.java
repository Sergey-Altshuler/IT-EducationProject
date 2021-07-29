package com.Altshuler.servlets;

import com.Altshuler.servlce.AdminServletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.Altshuler.info.ProjectPageConstants.PAGE_ADMIN_SUCCESS_CHANGE;
import static com.Altshuler.info.ProjectParamConstants.PARAM_LOGIN;
import static com.Altshuler.info.ProjectParamConstants.PARAM_PASSWORD;

@WebServlet("/adminChangeProperties")
public class AdminChangePropertiesServlet extends HttpServlet {
    private final AdminServletService adminServletService = new AdminServletService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        adminServletService.changeProperties(request.getParameter(PARAM_LOGIN), request.getParameter(PARAM_PASSWORD));
        request.setAttribute(PARAM_LOGIN, request.getParameter(PARAM_LOGIN));
        request.setAttribute(PARAM_PASSWORD, request.getParameter(PARAM_PASSWORD));
        request.getRequestDispatcher(PAGE_ADMIN_SUCCESS_CHANGE).forward(request, response);
    }
}
