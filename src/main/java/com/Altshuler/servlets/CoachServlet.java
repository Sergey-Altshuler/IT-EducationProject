package com.Altshuler.servlets;

import com.Altshuler.info.ProjectInfo;
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

@WebServlet(name = "coachServlet", value = "/coachServlet")
public class CoachServlet extends HttpServlet {
    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        request.setAttribute("courses", Manager.getAllCourses());
        request.setAttribute("coach", ProjectInfo.getCoach());
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/coachChooseCourse.jsp");
        requestDispatcher.forward(request, response);
    }

}
