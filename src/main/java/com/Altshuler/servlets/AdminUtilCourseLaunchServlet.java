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

@WebServlet(name = "adminUtilLaunchCourseServlet", value = "/adminUtilLaunchCourseServlet")
public class AdminUtilCourseLaunchServlet extends HttpServlet {
    @SneakyThrows
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        request.setAttribute("courses", Manager.getAllCourses());
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/adminLaunchCourse.jsp");
        requestDispatcher.forward(request, response);
    }
}
