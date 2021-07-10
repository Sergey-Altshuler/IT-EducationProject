package com.Altshuler.dao;


import com.Altshuler.model.Course;
import org.hibernate.query.Query;

public class DAOCourseImpl extends DAOImpl<Course> implements DAOCourse {
    @Override
    public void deleteById(int id) {
        transaction.begin();
        Query query = session.createQuery("delete from course where id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
    }
}
