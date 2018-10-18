package com.repository;

import com.entity.Task;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
@Log
@Transactional
public class TaskRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public TaskRepository(EntityManagerFactory entityManagerFactory) {
        sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }

    public List<Task> findAll() {
        Session session = sessionFactory.openSession();

        List<Task> tasks = session.createQuery("select t FROM Task t", Task.class).list();
        return tasks;
    }

    public Task findOne(Long id) {
        Session session = sessionFactory.openSession();
        try {
            log.info("try to get order with id=" + id);
           return session.createQuery( "select t FROM Task t where t.id = :task_id", Task.class)
                    .setParameter("task_id", id).getSingleResult();
        } catch (Exception e) {
            log.warning(e.getMessage());
            return null;
        }
    }
}
