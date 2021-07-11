package com.Altshuler.info;

import com.Altshuler.model.Coach;
import com.Altshuler.model.Course;
import com.Altshuler.model.Student;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProjectInfo {
    private static final String adminLogin="admin";
    private static final String adminPassword="password";
    private static Student student=null;
    private static Coach coach = null;
    private static Course course = null;
    private static Map<Course,Map<Student, Map<String, String>>> marks = new LinkedHashMap<>();

    public static Course getCourse() {
        return course;
    }

    public static void setCourse(Course course) {
        ProjectInfo.course = course;
    }

    public static Map<Course, Map<Student, Map<String, String>>> getMarks() {
        return marks;
    }

    public static void setMarks(Map<Course, Map<Student, Map<String, String>>> marks) {
        ProjectInfo.marks = marks;
    }

    public static Student getStudent() {
        return student;
    }

    public static void setStudent(Student student) {
        ProjectInfo.student = student;
    }

    public static Coach getCoach() {
        return coach;
    }

    public static void setCoach(Coach coach) {
        ProjectInfo.coach = coach;
    }

    public static String getAdminLogin() {
        return adminLogin;
    }

    public static String getAdminPassword() {
        return adminPassword;
    }
}
