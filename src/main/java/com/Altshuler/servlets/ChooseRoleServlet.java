package com.Altshuler.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "chooseRoleServlet", value = "/chooseRole-servlet")
public class ChooseRoleServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ServletContext servletContext = getServletContext();
        String role = request.getParameter("role");
        String path = "";
        switch (role) {
            case "admin": {
                path = "/adminValidate.jsp";
                break;
            }
            case "student": {
                path = "/studentValidate.jsp";
                break;
            }
            case "coach": {
                path = "/coachValidate.jsp";
                break;
            }
        }
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

}
