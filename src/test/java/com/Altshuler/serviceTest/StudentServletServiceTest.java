package com.Altshuler.serviceTest;

import com.Altshuler.dao.DAOStudent;
import com.Altshuler.dao.DAOStudentImpl;
import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Student;
import com.Altshuler.servlce.StudentServletService;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServletServiceTest {
    DAOStudent daoStudent= new DAOStudentImpl();
    StudentServletService studentServletService = new StudentServletService();

    @Test
    void add(){
        try {
            List<Student> list1 =  daoStudent.getAll(Student.class);
            studentServletService.add(Student.builder().name("new Student").build());
            List<Student> list2 =  daoStudent.getAll(Student.class);
            assertEquals(list1.size()+1, list2.size());
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Test
    void validate(){
        studentServletService.add(Student.builder().login("test").password("test").build());
        assertTrue(studentServletService.validate("test", "test"));
    }
    @Test
    void logIn(){
       studentServletService.add(Student.builder().login("test2").password("test2").build());
        studentServletService.logIn("test2","test2");
        assertEquals(ProjectInfo.getStudent().getPassword(),"test2");
    }
    @Test
     void getById(){
        studentServletService.add(Student.builder().name("New student").build());
        Student student1=null;
        Student student2=null;
        try {
            student1 = daoStudent.get(1, Student.class);
            student2 = studentServletService.getById(1);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        assertNotNull(student1);
        assertEquals(student1, student2);
    }
}
