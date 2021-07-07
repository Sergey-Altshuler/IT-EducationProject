package com.Altshuler.dao;

import com.Altshuler.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.Entity;
import java.sql.SQLException;
import java.util.List;


public class DAOImpl<T> implements DAO<T> {
    protected static final Session session = SessionUtil.getSession();
    private static final Transaction transaction = session.getTransaction();
    @Override
    public void save(T t) {
        try {
            transaction.begin();
            session.saveOrUpdate(t);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public T get(int id, Class<T> generic) throws SQLException {
       transaction.begin();
        T t = session.get(generic, id);
       transaction.commit();
        return t;
    }

    @Override
    public void deleteAll(Class<T> generic) {
            String annotationName = generic.getAnnotation(Entity.class).name();
            Query query = session.createQuery("delete from " + annotationName);
            query.executeUpdate();
    }

    @Override
    public void saveAll(List<T> t) throws SQLException {
       for (T obj : t){
          save(obj);
       }
    }

    @Override
    public List<T> getAll(Class<T> generic) throws SQLException {
       String annotationName = generic.getAnnotation(Entity.class).name();
        Query query = session.createQuery("from " + annotationName);
        return query.getResultList();
    }
}
