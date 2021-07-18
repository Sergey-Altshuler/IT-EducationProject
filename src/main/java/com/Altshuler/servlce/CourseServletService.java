package com.Altshuler.servlce;

import com.Altshuler.dao.DAOCourse;
import com.Altshuler.dao.DAOCourseImpl;
import com.Altshuler.model.Course;

import java.sql.SQLException;
import java.util.List;

public class CourseServletService {
    private final DAOCourse daoCourse = new DAOCourseImpl();

    public void add(Course course) {
        try {
            daoCourse.save(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Course getById(int id) {
        Course course = null;
        try {
            course = daoCourse.get(id, Course.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    public List<Course> getAll() {
        List<Course> courseList = null;
        try {
            courseList = daoCourse.getAll(Course.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public void deleteById (int id){
        try {
            daoCourse.delete(id, Course.class);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
