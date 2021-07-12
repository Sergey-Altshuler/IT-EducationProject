package com.Altshuler.servlets;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Course;
import com.Altshuler.model.Student;
import com.Altshuler.service.Manager;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "studentChooseCourseServlet", value = "/studentChooseCourseServlet")
public class StudentChooseCourseServlet extends HttpServlet {
    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        int num = Integer.parseInt(request.getParameter("number"));
        Course course = Manager.getCourseById(num);
        Student student = ProjectInfo.getStudent();
        if (course.getStudents() == null) {
            Set<Student> newSet = new HashSet<>();
            newSet.add(student);
            course.setStudents(newSet);
        } else {
            course.getStudents().add(student);
        }
        course.setRemaining(course.getRemaining() - 1);
        student.setCourse(course);
        Manager.addCourse(course);
        Manager.addStudent(student);
        ProjectInfo.setStudent(student);
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/studentSuccessEnroll.jsp");
        requestDispatcher.forward(request, response);
    }
}
