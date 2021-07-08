package com.Altshuler.service;

import com.Altshuler.dao.*;
import com.Altshuler.model.Course;
import com.Altshuler.model.Student;

import java.sql.SQLException;
import java.util.List;

public class Manager {
    public static final DAOStudent daoStudent = new DAOStudentImpl();
    public static final DAOCourse daoCourse = new DAOCourseImpl();
    public static final DAOStats daoStats = new DAOStatsImpl();
    public static final DAOCoach daoCoach = new DAOCoachImpl();

    public static void addCourse(Course course) throws SQLException {
        daoCourse.save(course);
    }
    public static List<Student> getAllStudents() throws SQLException {
        return daoStudent.getAll(Student.class);
    }
    public static List<Course> getAllCourses() throws SQLException {
        return daoCourse.getAll(Course.class);
    }
    public static Course getCourseById(int id) throws SQLException {
        return daoCourse.get(id, Course.class);
    }
    public static void addStudent(Student student) throws SQLException {
        daoStudent.save(student);
    }

}
