package com.Altshuler.info;

import com.Altshuler.model.Coach;
import com.Altshuler.model.Course;
import com.Altshuler.model.Student;

import java.util.HashMap;
import java.util.Map;

public class ProjectInfo {
    private static final String adminLogin="admin";
    private static final String adminPassword="password";
    private static Student student=null;
    private static Coach coach = null;

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
