package com.Altshuler.servlets;

import com.Altshuler.converters.CourseConverter;
import com.Altshuler.servletService.CourseServletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminAddCourseServlet")
public class AdminAddCourseServlet extends HttpServlet {
    CourseServletService courseServletService = new CourseServletService();
    CourseConverter courseConverter = new CourseConverter();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      courseServletService.add(courseConverter.convert(request));
      request.setAttribute("courses", courseServletService.getAll());
      request.getRequestDispatcher("/adminSuccessAdd.jsp").forward(request, response);

    }
}
