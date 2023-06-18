package com.demo.cruddemo.dao;

import com.demo.cruddemo.entity.Student;

public interface IStudentDao<Student> extends IGenericDao<Student> {
    public Student searchByName(String name);
}
