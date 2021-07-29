package com.Altshuler.servlets;

import com.Altshuler.converters.ConverterProvider;
import com.Altshuler.model.Course;
import com.Altshuler.servlce.CourseServletService;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.Altshuler.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.Altshuler.info.ProjectPageConstants.PAGE_ADMIN_SUCCESS_ADD;

@WebServlet("/adminAddCourse")
public class AdminAddCourseServlet extends HttpServlet {
    private final CourseServletService courseServletService = new CourseServletService();

    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        courseServletService.add(ConverterProvider.convert(Course.class, request));
        request.setAttribute(ATTR_COURSES, courseServletService.getAll());
        request.getRequestDispatcher(PAGE_ADMIN_SUCCESS_ADD).forward(request, response);

    }
}
