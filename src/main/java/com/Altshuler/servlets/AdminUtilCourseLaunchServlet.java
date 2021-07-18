package com.Altshuler.servlets;

import com.Altshuler.servlce.CourseServletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminUtilLaunchCourseServlet")
public class AdminUtilCourseLaunchServlet extends HttpServlet {
    CourseServletService courseServletService = new CourseServletService();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("courses", courseServletService.getAll());
        request.getRequestDispatcher("/adminLaunchCourse.jsp").forward(request, response);
    }
}
