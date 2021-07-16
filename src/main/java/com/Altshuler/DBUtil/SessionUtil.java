package com.Altshuler.DBUtil;

import com.Altshuler.model.Coach;
import com.Altshuler.model.Course;
import com.Altshuler.model.Stats;
import com.Altshuler.model.Student;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
    @Getter
    private static SessionFactory sessionFactory;

    private SessionUtil() {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Coach.class);
            configuration.addAnnotatedClass(Course.class);
            configuration.addAnnotatedClass(Stats.class);
            configuration.addAnnotatedClass(Student.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initialize() {
        if (getSessionFactory() == null) {
            new SessionUtil();
        }
    }

    public static Session getSession() {
        initialize();
        return sessionFactory.openSession();
    }

    public static void stopSessionFactory() {
        if (sessionFactory != null) // когда закрываешь, нужен ли hibernateUtil
            sessionFactory.close();
    }
}

