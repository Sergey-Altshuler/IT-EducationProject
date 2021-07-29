package com.Altshuler.serviceTest;

import com.Altshuler.TestInfo.TestDataCreator;
import com.Altshuler.dao.DAOStudent;
import com.Altshuler.dao.DAOStudentImpl;
import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Student;
import com.Altshuler.servlce.StudentServletService;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static com.Altshuler.TestInfo.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServletServiceTest {
    DAOStudent daoStudent = new DAOStudentImpl();
    StudentServletService studentServletService = new StudentServletService();

    @Test
    void add() {
        try {
            List<Student> list1 = daoStudent.getAll(Student.class);
            studentServletService.add(TestDataCreator.createNewTestStudent());
            List<Student> list2 = daoStudent.getAll(Student.class);
            assertEquals(list1.size() + 1, list2.size());
        } catch (SQLException e) {
            fail();
        }
    }

    @Test
    void validate() {
        studentServletService.add(TestDataCreator.createValidateTestStudent());
        assertTrue(studentServletService.validate(VALIDATE_LOGIN, VALIDATE_PASSWORD));
    }

    @Test
    void logIn() {
        studentServletService.add(TestDataCreator.createLoginTestStudent());
        studentServletService.logIn(ENTER_LOGIN, ENTER_PASSWORD);
        assertEquals(ProjectInfo.getStudent().getPassword(), ENTER_PASSWORD);
    }

    @Test
    void getById() {
        studentServletService.add(TestDataCreator.createNewTestStudent());
        Student student1 = null;
        Student student2 = null;
        try {
            student1 = daoStudent.get(1, Student.class);
            student2 = studentServletService.getById(1);
        } catch (SQLException e) {
            fail();
        }
        assertNotNull(student1);
        assertEquals(student1, student2);
    }
}
