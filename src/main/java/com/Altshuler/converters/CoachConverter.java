package com.Altshuler.converters;

import com.Altshuler.model.Coach;

import javax.servlet.http.HttpServletRequest;

public class CoachConverter {
    public Coach convert(HttpServletRequest request) {
        return Coach.builder()
                .login(request.getParameter("login"))
                .age(Integer.parseInt(request.getParameter("age")))
                .password(request.getParameter("password"))
                .name(request.getParameter("name"))
                .surname(request.getParameter("surname"))
                .build();

    }
}
