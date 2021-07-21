package com.Altshuler;

import com.Altshuler.model.*;
import com.Altshuler.servlce.*;
import org.junit.jupiter.api.BeforeEach;

public class H2DataGenerator {
    protected Student student;
    protected Coach coach;
    protected Stats stats;
    protected Course course;

    @BeforeEach
    public void generateData() {
        StudentServletService studentServletService = new StudentServletService();
        AdminServletService adminServletService = new AdminServletService();
        CoachServletService coachServletService = new CoachServletService();
        StatsServletService statsServletService = new StatsServletService();
        CourseServletService courseServletService = new CourseServletService();
        adminServletService.initialize();
        student = Student.builder().name("student").surname("student").login("login").password("password").build();
        coach = Coach.builder().name("coach").surname("coach").login("login").password("password").build();
        stats = Stats.builder().avgMark(10d).attendance(100d).build();
        course = Course.builder().title("Course").build();
        studentServletService.add(student);
        coachServletService.add(coach);
        statsServletService.add(stats);
        courseServletService.add(course);
    }
}
