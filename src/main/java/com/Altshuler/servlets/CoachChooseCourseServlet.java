package com.Altshuler.servlets;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Coach;
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

@WebServlet(name = "coachChooseCourseServlet", value = "/coachChooseCourseServlet")
public class CoachChooseCourseServlet extends HttpServlet {
    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        int num = Integer.parseInt(request.getParameter("number"));
        Course course = Manager.getCourseById(num);
        Coach coach = ProjectInfo.getCoach();

        if (coach.getCourseSet() == null) {
            Set<Course> newSet = new HashSet<>();
            newSet.add(course);
            coach.setCourseSet(newSet);
        } else {
            coach.getCourseSet().add(course);
        }
        course.setCoach(coach);
        Manager.addCoach(coach);
        Manager.addCourse(course);
        ProjectInfo.setCoach(coach);

        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/coachSuccessEnroll.jsp");
        requestDispatcher.forward(request, response);
    }
}
