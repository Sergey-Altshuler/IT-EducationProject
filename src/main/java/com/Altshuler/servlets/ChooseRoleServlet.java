package com.Altshuler.servlets;

import com.Altshuler.info.ProjectInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/chooseRole-servlet")
public class ChooseRoleServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = ProjectInfo.getRoles().get(request.getParameter("role"));
        request.getRequestDispatcher(path).forward(request, response);
    }

}
