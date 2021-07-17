package com.Altshuler.servlets;

import com.Altshuler.model.Course;
import com.Altshuler.servletService.CourseServletService;
import com.Altshuler.util.MarkUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminLaunchCourseServlet")
public class adminLaunchCourseServlet extends HttpServlet {
    CourseServletService courseServletService = new CourseServletService();
    MarkUtil markUtil = new MarkUtil();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Course course = courseServletService.getById(Integer.parseInt(request.getParameter("number")));
        course.setIsStarted("true");
        courseServletService.add(course);
        markUtil.initializeMarks(course);
        request.getRequestDispatcher("/adminSuccessLaunch.jsp").forward(request, response);
    }
}
