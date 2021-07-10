package com.Altshuler.servlets;

import com.Altshuler.service.Manager;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminDropCourseServlet", value = "/adminDropCourseServlet")
public class AdminDropCourseServlet extends HttpServlet {
    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        int num = Integer.parseInt(request.getParameter("number"));
        Manager.deleteCourseById(num);
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/adminActions.jsp");
        requestDispatcher.forward(request, response);
    }
}
