package com.Altshuler.service;

import com.Altshuler.dao.*;
import com.Altshuler.model.Coach;
import com.Altshuler.model.Course;
import com.Altshuler.model.Stats;
import com.Altshuler.model.Student;

import java.sql.SQLException;
import java.util.List;

public class Manager { // убрать статику. сделать как service и имплементацию
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
    public static void addCoach(Coach coach) throws SQLException {
        daoCoach.save(coach);
    }
    public static List<Coach> getAllCoaches() throws SQLException {
        return daoCoach.getAll(Coach.class);
    }
    public static void deleteCourseById(int id) throws SQLException {
        daoCourse.delete(id, Course.class);
    }
    public static Student getStudentById(int id) throws SQLException {
        return daoStudent.get(id, Student.class);
    }
    public static void addStats(Stats stats) throws SQLException {
        daoStats.save(stats);
    }
    public static List<Stats> getAllStats() throws SQLException {
        return daoStats.getAll(Stats.class);
    }

}
