package com.Altshuler.servlets;

import com.Altshuler.converter.CoachConverter;
import com.Altshuler.servletService.CoachServletService;

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
        request.getRequestDispatcher("/coachSuccessRegister.jsp").forward(request, response);
    }

}
