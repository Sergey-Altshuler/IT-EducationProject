package com.Altshuler.servlets;

import com.Altshuler.servletService.CourseServletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminUtilDeleteCourseServlet")
public class AdminUtilDeleteCourseServlet extends HttpServlet {
   CourseServletService courseServletService= new CourseServletService();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("courses", courseServletService.getAll());
        request.getRequestDispatcher("/adminDeleteCourse.jsp").forward(request, response);
    }
}
