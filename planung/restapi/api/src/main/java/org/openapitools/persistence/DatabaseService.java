package org.openapitools.persistence;

import org.openapitools.model.Area;
import org.springframework.stereotype.Component;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

@Component
public class DatabaseService {
    public void getConnection() {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Execute an SQL query and map the result to MyEntity class
            List<Area> entities = session.createQuery("select a FROM Area a", Area.class).list();

            for (Area entity : entities) {
                // Process retrieved entities
                System.out.println("ID: " + entity.getId() + ", Name: " + entity.getName());
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
