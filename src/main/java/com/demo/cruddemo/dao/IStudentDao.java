package com.demo.cruddemo.dao;

import com.demo.cruddemo.entity.Student;

import java.util.List;

public interface IStudentDao<Student> extends IGenericDao<Student> {
    public List<Student> findByLastName(String lastName);
}
