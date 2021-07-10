package com.Altshuler.servlets;

import com.Altshuler.model.Coach;
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

@WebServlet(name = "coachRegisterServlet", value = "/coachRegisterServlet")
public class CoachRegisterServlet extends HttpServlet {
    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        Coach coach = Coach.builder().login(request.getParameter("login")).build();
        coach.setAge(Integer.parseInt(request.getParameter("age")));
        coach.setPassword(request.getParameter("password"));
        coach.setName(request.getParameter("name"));
        coach.setSurname(request.getParameter("surname"));
        Manager.addCoach(coach);

        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/coachSuccessRegister.jsp");
        requestDispatcher.forward(request, response);
    }

}
