package com.demo.cruddemo.dao;

import jakarta.transaction.Transactional;

import java.util.List;

public interface IGenericDao<E> {

    void create(E entity);
    E findById(Object id);

    List<E> findAll();
    void update(E entity);
    void delete(Object id);
}
