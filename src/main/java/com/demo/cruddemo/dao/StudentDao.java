package com.demo.cruddemo.dao;
import com.demo.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao extends GenericDao<Student> implements IStudentDao<Student> {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:theLastName", Student.class);
        query.setParameter("theLastName", lastName);

        return query.getResultList();
    }
}
