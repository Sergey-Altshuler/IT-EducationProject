package com.Altshuler.servlets;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Course;
import com.Altshuler.model.Student;
import com.Altshuler.servlce.CourseServletService;
import com.Altshuler.servlce.StudentServletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentChooseCourseServlet")
public class StudentChooseCourseServlet extends HttpServlet {
    CourseServletService courseServletService = new CourseServletService();
    StudentServletService studentServletService = new StudentServletService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Course course = courseServletService.getById(Integer.parseInt(request.getParameter("number")));
        Student student = ProjectInfo.getStudent();
        course.addStudent(student);
        student.setCourse(course);
        courseServletService.add(course);
        studentServletService.add(student);
        ProjectInfo.setStudent(student);
        request.setAttribute("course", course);
        request.getRequestDispatcher("/studentSuccessEnroll.jsp").forward(request, response);

    }
}
