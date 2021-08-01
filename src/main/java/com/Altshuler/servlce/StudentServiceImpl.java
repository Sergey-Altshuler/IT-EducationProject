package com.Altshuler.servlce;

import com.Altshuler.dao.DAOStudent;
import com.Altshuler.dao.DAOStudentImpl;
import com.Altshuler.info.ProjectInfo;
import com.Altshuler.model.Student;
import com.Altshuler.util.HQLUtil;

import java.sql.SQLException;

public class StudentServiceImpl implements StudentService{
    private final DAOStudent daoStudent = new DAOStudentImpl();
    private final HQLUtil hqlUtil = new HQLUtil();

    public void add(Student student) {
        try {
            daoStudent.save(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student getById(int id) {
        Student student = null;
        try {
            student = daoStudent.get(id, Student.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public boolean validate(String login, String password) {
        return hqlUtil.checkStudent(login, password) != null;
    }

    public void logIn(String login, String password) {
        ProjectInfo.setStudent(hqlUtil.checkStudent(login, password));
    }

}
