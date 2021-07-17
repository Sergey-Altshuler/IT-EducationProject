package com.Altshuler.servlets;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Coach;
import com.Altshuler.model.Course;
import com.Altshuler.model.Student;
import com.Altshuler.service.Manager;
import com.Altshuler.servletService.CoachServletService;
import com.Altshuler.servletService.CourseServletService;
import com.Altshuler.servletService.StudentServletService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/studentChooseCourseServlet")
public class StudentChooseCourseServlet extends HttpServlet {
    CourseServletService courseServletService = new CourseServletService();
    StudentServletService studentServletService = new StudentServletService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Course course = courseServletService.getById(Integer.parseInt(request.getParameter("number")));
        Student student = ProjectInfo.getStudent();
        course.addStudent(student);
        student.setCourse(course);
        courseServletService.add(course);
        studentServletService.add(student);
        ProjectInfo.setStudent(student);
        request.getRequestDispatcher("/studentSuccessEnroll.jsp").forward(request, response);

    }
}
