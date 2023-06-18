package com.demo.cruddemo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericDao<T> implements IGenericDao<T>{
    @PersistenceContext
    private EntityManager entityManager;
    private Class<T> type;
    public GenericDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    @Transactional
    public void create(T t) {
        entityManager.persist(t);
    }

    @Override
    public T findById(Object id) {
        return entityManager.find(type, id);
    }
}
