package com.Altshuler.servlets;

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

@WebServlet(name = "studentRegisterServlet", value = "/studentRegisterServlet")
public class StudentRegisterServlet extends HttpServlet {
    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        Student student= Student.builder().login(request.getParameter("login")).build();
        student.setAge(Integer.parseInt(request.getParameter("age")));
        student.setPassword(request.getParameter("password"));
        student.setInterests(request.getParameter("interests"));
        student.setName(request.getParameter("name"));
        student.setSurname(request.getParameter("surname"));
        Manager.addStudent(student);

        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/studentSuccessRegister.jsp");
        requestDispatcher.forward(request, response);
    }
}
