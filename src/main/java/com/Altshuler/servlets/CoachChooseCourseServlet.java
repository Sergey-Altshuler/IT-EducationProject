package com.Altshuler.servlets;

import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Coach;
import com.Altshuler.model.Course;
import com.Altshuler.servletService.CoachServletService;
import com.Altshuler.servletService.CourseServletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/coachChooseCourseServlet")
public class CoachChooseCourseServlet extends HttpServlet {
    CoachServletService coachServletService = new CoachServletService();
    CourseServletService courseServletService = new CourseServletService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Course course = courseServletService.getById(Integer.parseInt(request.getParameter("number")));
        Coach coach = ProjectInfo.getCoach();
        coach.addCourse(course);
        course.setCoach(coach);
        coachServletService.add(coach);
        courseServletService.add(course);
        ProjectInfo.setCoach(coach);
        request.getRequestDispatcher("/coachSuccessEnroll.jsp").forward(request, response);

    }
}
