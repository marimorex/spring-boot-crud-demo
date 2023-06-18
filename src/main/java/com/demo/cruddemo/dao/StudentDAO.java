package com.demo.cruddemo.dao;

import com.demo.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO implements GenericDAO<Student> {
    private EntityManager entityManager;

    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theEntity) {
        entityManager.persist(theEntity);
    }
}
