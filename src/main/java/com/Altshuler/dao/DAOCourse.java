package com.Altshuler.dao;

import com.Altshuler.model.Course;

public interface DAOCourse extends DAO<Course> {
 void deleteById(int id);

}
