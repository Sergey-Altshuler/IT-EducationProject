package com.Altshuler.servlets;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Course;
import com.Altshuler.model.Student;
import com.Altshuler.service.DataParser;
import com.Altshuler.service.Manager;
import com.Altshuler.service.MarkSetter;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "coachPutMarksServlet", value = "/coachPutMarksServlet")
public class CoachPutMarksServlet extends HttpServlet {
    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        Course course = Manager.getCourseById(Integer.parseInt(request.getParameter("number")));
        ProjectInfo.setCourse(course);
        Student student = course.getStudents().stream().findAny().get();
        Map<Student, Map<String,String>> courseMap = ProjectInfo.getMarks().get(course);
        request.setAttribute("courseMap",courseMap);
        request.setAttribute("titles", courseMap.get(student));
        request.setAttribute("numToFill", MarkSetter.getIsFinished(course));
        Map<Integer, String> studentAdditionalMap = new LinkedHashMap<>();
        for (Student stud: course.getStudents()){
            studentAdditionalMap.put(stud.getId(), DataParser.parseStudent(stud));
        }
        request.setAttribute("studentMap", studentAdditionalMap);

        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/coachPutMarks.jsp");
        requestDispatcher.forward(request, response);

    }
}
