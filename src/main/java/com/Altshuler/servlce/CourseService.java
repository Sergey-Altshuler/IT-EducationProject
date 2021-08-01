package com.Altshuler.servlce;

import com.Altshuler.model.Course;

import java.util.List;

public interface CourseService {
    void add(Course course);
    Course getById(int id);
    List<Course> getAll();
    void deleteById(int id);
}
