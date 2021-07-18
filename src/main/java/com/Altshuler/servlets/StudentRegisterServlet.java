package com.Altshuler.servlets;

import com.Altshuler.converters.StudentConverter;
import com.Altshuler.servlce.StudentServletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentRegisterServlet")
public class StudentRegisterServlet extends HttpServlet {
    StudentServletService studentServletService = new StudentServletService();
    StudentConverter studentConverter = new StudentConverter();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       studentServletService.add(studentConverter.convert(request));
       request.setAttribute("login", request.getParameter("login"));
       request.setAttribute("password", request.getParameter("password"));
       request.getRequestDispatcher("/studentSuccessRegister.jsp").forward(request, response);
    }
}
