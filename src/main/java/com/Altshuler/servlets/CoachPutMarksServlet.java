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
import java.util.Map;

@WebServlet(name = "coachPutMarksServlet", value = "/coachPutMarksServlet")
public class CoachPutMarksServlet extends HttpServlet {
    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        Course course = Manager.getCourseById(Integer.parseInt(request.getParameter("number")));
        Student student = course.getStudents().stream().findAny().get();
        Map<Student, Map<String,String>> courseMap = ProjectInfo.getMarks().get(course);
        request.setAttribute("courseMap",courseMap);
        request.setAttribute("titles", courseMap.get(student));
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/coachPutMarks.jsp");
        requestDispatcher.forward(request, response);

    }
}
