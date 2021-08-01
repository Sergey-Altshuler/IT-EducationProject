package com.Altshuler.servlets;

import com.Altshuler.converters.ConverterProvider;
import com.Altshuler.model.Coach;
import com.Altshuler.servlce.CoachService;
import com.Altshuler.servlce.CoachServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.Altshuler.info.ProjectPageConstants.PAGE_COACH_SUCCESS_REGISTER;
import static com.Altshuler.info.ProjectParamConstants.PARAM_LOGIN;
import static com.Altshuler.info.ProjectParamConstants.PARAM_PASSWORD;

@WebServlet("/coachRegister")
public class CoachRegisterServlet extends HttpServlet {
    private final CoachService coachService = new CoachServiceImpl();

    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        coachService.add(ConverterProvider.convert(Coach.class, request));
        request.setAttribute(PARAM_LOGIN, request.getParameter(PARAM_LOGIN));
        request.setAttribute(PARAM_PASSWORD, request.getParameter(PARAM_PASSWORD));
        request.getRequestDispatcher(PAGE_COACH_SUCCESS_REGISTER).forward(request, response);
    }

}
