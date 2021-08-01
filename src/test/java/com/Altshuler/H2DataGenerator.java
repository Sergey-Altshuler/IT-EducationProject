package com.Altshuler;

import com.Altshuler.TestInfo.TestDataCreator;
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
        StudentService studentService = new StudentServiceImpl();
        AdminService adminService = new AdminServiceImpl();
        CoachService coachService = new CoachServiceImpl();
        StatsService statsService = new StatsServiceImpl();
        CourseService courseService = new CourseServiceImpl();
        adminService.initialize();
        student = TestDataCreator.createTestStudent();
        coach = TestDataCreator.createTestCoach();
        stats = TestDataCreator.createTestStats();
        course = TestDataCreator.createTestCourse();
        studentService.add(student);
        coachService.add(coach);
        statsService.add(stats);
        courseService.add(course);
    }
}
