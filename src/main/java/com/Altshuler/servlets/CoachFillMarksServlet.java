package com.Altshuler.servlets;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Course;
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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "coachFillMarksServlet", value = "/coachFillMarksServlet")
public class CoachFillMarksServlet extends HttpServlet {
    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        Course course = ProjectInfo.getCourse();
        int numLesson = Integer.parseInt(request.getParameter("numLesson"));
        Enumeration<String> params = request.getParameterNames();
        Map<String, String> studentsAndMarks = new HashMap<>();
        while (params.hasMoreElements()){
            String param = params.nextElement();
            if (!param.equals("numLesson"))
                studentsAndMarks.put(param, request.getParameter(param));
        }
        MarkSetter.setLessonMarks(course, studentsAndMarks, numLesson);
        request.setAttribute("courses", Manager.getAllCourses());
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/coachSuccessPutMarks.jsp");
        requestDispatcher.forward(request, response);
    }
}
