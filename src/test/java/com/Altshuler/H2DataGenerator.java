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
        StudentServletService studentServletService = new StudentServletService();
        AdminServletService adminServletService = new AdminServletService();
        CoachServletService coachServletService = new CoachServletService();
        StatsServletService statsServletService = new StatsServletService();
        CourseServletService courseServletService = new CourseServletService();
        adminServletService.initialize();
        student = TestDataCreator.createTestStudent();
        coach = TestDataCreator.createTestCoach();
        stats = TestDataCreator.createTestStats();
        course = TestDataCreator.createTestCourse();
        studentServletService.add(student);
        coachServletService.add(coach);
        statsServletService.add(stats);
        courseServletService.add(course);
    }
}
