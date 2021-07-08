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

@WebServlet(name = "studentServlet", value = "/studentServlet")
public class StudentServlet extends HttpServlet {
    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        request.setAttribute("courses", Manager.getAllCourses());
        request.setAttribute("student", ProjectInfo.getStudent());
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/studentChooseCourse.jsp");
        requestDispatcher.forward(request, response);
    }
}
