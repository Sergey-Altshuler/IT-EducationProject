package com.Altshuler.servlets;

import com.Altshuler.servlce.CourseService;
import com.Altshuler.servlce.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.Altshuler.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.Altshuler.info.ProjectPageConstants.PAGE_ADMIN_LAUNCH_COURSE;

@WebServlet("/adminUtilLaunchCourse")
public class AdminUtilCourseLaunchServlet extends HttpServlet {
    private final CourseService courseService = new CourseServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute(ATTR_COURSES, courseService.getAll());
        request.getRequestDispatcher(PAGE_ADMIN_LAUNCH_COURSE).forward(request, response);
    }
}
