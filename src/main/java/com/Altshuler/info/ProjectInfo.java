package com.Altshuler.info;

import com.Altshuler.model.Coach;
import com.Altshuler.model.Course;
import com.Altshuler.model.Student;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProjectInfo {
    private static Student currentStudent = null;
    private static Coach currentCoach = null;
    private static Course currentCourse = null;
    private static Map<Course, Map<Student, Map<String, String>>> marks = new LinkedHashMap<>();

    public static Course getCourse() {
        return currentCourse;
    }

    public static void setCourse(Course course) {
        ProjectInfo.currentCourse = course;
    }

    public static Map<Course, Map<Student, Map<String, String>>> getMarks() {
        return marks;
    }

    public static void setMarks(Map<Course, Map<Student, Map<String, String>>> marks) {
        ProjectInfo.marks = marks;
    }

    public static Student getStudent() {
        return currentStudent;
    }

    public static void setStudent(Student student) {
        ProjectInfo.currentStudent = student;
    }

    public static Coach getCoach() {
        return currentCoach;
    }

    public static void setCoach(Coach coach) {
        ProjectInfo.currentCoach = coach;
    }

}
