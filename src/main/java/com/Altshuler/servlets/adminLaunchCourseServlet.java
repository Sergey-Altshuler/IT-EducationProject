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

import static com.Altshuler.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.Altshuler.info.ProjectNamedConstants.YES;
import static com.Altshuler.info.ProjectPageConstants.PAGE_ADMIN_LAUNCH_COURSE;
import static com.Altshuler.info.ProjectParamConstants.PARAM_LAUNCH_ID;

@WebServlet("/adminLaunchCourse")
public class adminLaunchCourseServlet extends HttpServlet {
    private final CourseServletService courseServletService = new CourseServletService();
    private final MarkUtil markUtil = new MarkUtil();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter(PARAM_LAUNCH_ID) != null) {
            Course course = courseServletService.getById(Integer.parseInt(request.getParameter(PARAM_LAUNCH_ID)));
            course.setIsStarted(YES);
            courseServletService.add(course);
            markUtil.initializeMarks(course);
        }
        request.setAttribute(ATTR_COURSES, courseServletService.getAll());
        request.getRequestDispatcher(PAGE_ADMIN_LAUNCH_COURSE).forward(request, response);
    }
}
