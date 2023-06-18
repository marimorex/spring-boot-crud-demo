package com.demo.cruddemo.dao;

import jakarta.transaction.Transactional;

public interface IGenericDao<T> {

    void create(T t);
    T findById(Object id);
}
