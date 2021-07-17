package com.Altshuler.servlets;

import com.Altshuler.servletService.CourseServletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminDropCourseServlet")
public class AdminDropCourseServlet extends HttpServlet {
    CourseServletService courseServletService = new CourseServletService();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        courseServletService.deleteById(Integer.parseInt(request.getParameter("number")));
        request.getRequestDispatcher("/adminSuccessDrop.jsp").forward(request, response);

    }
}
