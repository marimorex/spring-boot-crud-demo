package com.demo.cruddemo.dao;
import com.demo.cruddemo.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao extends GenericDao<Student> implements IStudentDao<Student> {
    @Override
    public Student searchByName(String name) {
        return null;
    }
}
