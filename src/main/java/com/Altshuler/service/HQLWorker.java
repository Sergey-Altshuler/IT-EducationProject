package com.Altshuler.service;

import com.Altshuler.dao.DAOCourse;
import com.Altshuler.dao.DAOCourseImpl;
import com.Altshuler.model.Course;

import java.sql.SQLException;
import java.util.List;

public class HQLWorker {
   /* public static int getSubgroupNum(String title) throws SQLException {
        List<Course> courseList = new DAOCourseImpl().getAll(Course.class);
        int count = 1; //что вернет если courseList.size==0??? переделать через map <Name, count>
        for (Course course: courseList){
            if (course.getTitle().equals(title)) count++;
        }
        return count;
    }*/
}
