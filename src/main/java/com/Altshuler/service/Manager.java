package com.Altshuler.service;

import com.Altshuler.dao.*;
import com.Altshuler.model.Course;

import java.sql.SQLException;

public class Manager {
    public static final DAOStudent daoStudent = new DAOStudentImpl();
    public static final DAOCourse daoCourse = new DAOCourseImpl();
    public static final DAOStats daoStats = new DAOStatsImpl();
    public static final DAOCoach daoCoach = new DAOCoachImpl();

    public static void addCourse(Course course) throws SQLException {
        daoCourse.save(course);
    }
}
