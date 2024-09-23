package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/katashema";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            try{
                Configuration configuration = new Configuration();
                Properties setHiber = new Properties();
                setHiber.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                setHiber.put(Environment.URL, URL);
                setHiber.put(Environment.USER, USERNAME);
                setHiber.put(Environment.PASS, PASSWORD);
                setHiber.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                setHiber.put(Environment.SHOW_SQL,"true");
                setHiber.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                configuration.setProperties(setHiber);
                configuration.addAnnotatedClass(User.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }catch (Exception e) {
                e.printStackTrace();
            }

        }
    return sessionFactory;
    }

}
