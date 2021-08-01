package com.Altshuler.serviceTest;

import com.Altshuler.TestInfo.TestDataCreator;
import com.Altshuler.dao.DAOCourse;
import com.Altshuler.dao.DAOCourseImpl;
import com.Altshuler.model.Course;
import com.Altshuler.servlce.CourseService;
import com.Altshuler.servlce.CourseServiceImpl;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CourseServiceImplTest {
    CourseService courseService = new CourseServiceImpl();
    DAOCourse daoCourse = new DAOCourseImpl();

    @Test
    void add() {
        try {
            List<Course> list1 = daoCourse.getAll(Course.class);
            courseService.add(TestDataCreator.createTestAddCourse());
            List<Course> list2 = daoCourse.getAll(Course.class);
            assertEquals(list1.size() + 1, list2.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getById() {
        try {
            courseService.add(TestDataCreator.createTestGetByIdCourse());
            List<Course> list = daoCourse.getAll(Course.class);
            Course course1 = courseService.getById(list.size());
            Course course2 = daoCourse.get(list.size(), Course.class);
            assertEquals(course1, course2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getAll() {
        try {
            courseService.add(TestDataCreator.createTestGetAllCourse());
            List<Course> daoList = daoCourse.getAll(Course.class);
            List<Course> serviceList = courseService.getAll();
            assertEquals(daoList, serviceList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteById() {
        courseService.add(TestDataCreator.createTestDeleteByIdCourse());
        List<Course> courseList = courseService.getAll();
        int number = courseList.size();
        courseService.deleteById(number);
        assertNull(courseService.getById(number));
    }
}
