package com.Altshuler.servlets;

import com.Altshuler.model.Course;
import com.Altshuler.servlce.CourseServletService;
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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("launchId") != null) {
            Course course = courseServletService.getById(Integer.parseInt(request.getParameter("launchId")));
            course.setIsStarted("true");
            courseServletService.add(course);
            markUtil.initializeMarks(course);
        }
        request.setAttribute("courses", courseServletService.getAll());
        request.getRequestDispatcher("/adminLaunchCourse.jsp").forward(request, response);
    }
}
