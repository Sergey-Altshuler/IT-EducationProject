package com.Altshuler.servlets;

import com.Altshuler.info.ProjectInfo;
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

@WebServlet(name = "calculateServlet", value = "/calculateServlet")
public class CalculateServlet extends HttpServlet {
    @SneakyThrows
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        MarkSetter.calculateIndividualStatistics(ProjectInfo.getCourse());
        MarkSetter.calculateTotalStatistics(ProjectInfo.getCourse());
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/coachValidate.jsp");
        requestDispatcher.forward(request, response);
    }
}
