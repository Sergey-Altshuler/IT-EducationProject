package com.Altshuler.serviceTest;

import com.Altshuler.TestInfo.TestDataCreator;
import com.Altshuler.dao.DAOCourse;
import com.Altshuler.dao.DAOCourseImpl;
import com.Altshuler.model.Course;
import com.Altshuler.servlce.CourseServletService;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CourseServletServiceTest {
    CourseServletService courseServletService = new CourseServletService();
    DAOCourse daoCourse = new DAOCourseImpl();

    @Test
    void add() {
        try {
            List<Course> list1 = daoCourse.getAll(Course.class);
            courseServletService.add(TestDataCreator.createTestAddCourse());
            List<Course> list2 = daoCourse.getAll(Course.class);
            assertEquals(list1.size() + 1, list2.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getById() {
        try {
            courseServletService.add(TestDataCreator.createTestGetByIdCourse());
            List<Course> list = daoCourse.getAll(Course.class);
            Course course1 = courseServletService.getById(list.size());
            Course course2 = daoCourse.get(list.size(), Course.class);
            assertEquals(course1, course2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAll() {
        try {
            courseServletService.add(TestDataCreator.createTestGetAllCourse());
            List<Course> daoList = daoCourse.getAll(Course.class);
            List<Course> serviceList = courseServletService.getAll();
            assertEquals(daoList, serviceList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteById() {
        courseServletService.add(TestDataCreator.createTestDeleteByIdCourse());
        List<Course> courseList = courseServletService.getAll();
        int number = courseList.size();
        courseServletService.deleteById(number);
        assertNull(courseServletService.getById(number));
    }
}
