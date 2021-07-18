package com.Altshuler.servlets;

import com.Altshuler.converters.CoachConverter;
import com.Altshuler.servlce.CoachServletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/coachRegisterServlet")
public class CoachRegisterServlet extends HttpServlet {
    CoachServletService coachServletService = new CoachServletService();
    CoachConverter coachConverter = new CoachConverter();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        coachServletService.add(coachConverter.convert(request));
        request.setAttribute("login", request.getParameter("login"));
        request.setAttribute("password", request.getParameter("password"));
        request.getRequestDispatcher("/coachSuccessRegister.jsp").forward(request, response);
    }

}
