package com.Altshuler.servlce;

import com.Altshuler.model.Student;

public interface StudentService {
    void add(Student student);
    Student getById(int id);
    boolean validate(String login, String password);
    void logIn(String login, String password);
}
