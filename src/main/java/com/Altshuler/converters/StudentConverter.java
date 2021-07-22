package com.Altshuler.converters;

import com.Altshuler.model.Student;

import javax.servlet.http.HttpServletRequest;

public class StudentConverter {
    public Student convert(HttpServletRequest request) {
        return Student.builder()
                .login(request.getParameter("login"))
                .age(Integer.parseInt(request.getParameter("age")))
                .password(request.getParameter("password"))
                .name(request.getParameter("name"))
                .surname(request.getParameter("surname"))
                .interests(request.getParameter("interests"))
                .build();
    }
}
