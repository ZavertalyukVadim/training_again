package com.repository;

import com.entity.Task;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
@Log4j2
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
            log.debug("try to get order with id=" + id);
            return session.byId(Task.class).load(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
