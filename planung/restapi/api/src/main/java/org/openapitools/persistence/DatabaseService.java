package org.openapitools.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.openapitools.model.Area;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.IOException;
import java.util.List;

@Component
public class DatabaseService implements AutoCloseable {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    private EntityTransaction startTransaction() throws IOException {

        try {
            EntityTransaction transaction = entityManager.getTransaction();
            if(transaction.isActive()) throw new IllegalStateException("Transaction is already active");
            transaction.begin();
            return transaction;

        } catch (IllegalStateException e) {
            throw new IOException(e);
        }
    }
    public <T> void persist(T entity) throws IOException{
        EntityTransaction transaction = startTransaction();
        try {
            entityManager.persist(entity);
            transaction.commit();
        } catch (EntityExistsException e) {
            throw new IOException("Entity already exists");
        }catch (Exception e){
            throw new IOException(e);
        }
    }

    public <T> void merge(T entity) throws IOException{
        EntityTransaction transaction = startTransaction();
        try {
            entityManager.merge(entity);
            transaction.commit();
        } catch (Exception e){
            throw new IOException(e);
        }
    }
    public <T> void remove(T entity) throws IOException{
        EntityTransaction transaction = startTransaction();
        try {
            entityManager.remove(entity);
            transaction.commit();
        } catch (Exception e){
            throw new IOException(e);
        }
    }
    public <T> void remove(List<T> entities) throws IOException{
        EntityTransaction transaction = startTransaction();
        try {
            for(T entity : entities){
                entityManager.remove(entity);
            }
            
            transaction.commit();
        } catch (Exception e){
            throw new IOException(e);
        }
    }

    public <T, K> T find(Class<T> clazz, K key) throws IOException{
        EntityTransaction transaction = startTransaction();
        try {
            T result = entityManager.find(clazz, key);
            transaction.commit();
            return result;
        } catch (Exception e){
            throw new IOException(e);
        }
    }

    public <T> TypedQuery<T> query(String queryName, Class<T> resultClass){
        return entityManager.createNamedQuery(queryName, resultClass);
    }



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

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
