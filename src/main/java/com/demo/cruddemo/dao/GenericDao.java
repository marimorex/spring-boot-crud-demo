package com.demo.cruddemo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericDao<E> implements IGenericDao<E>{
    @PersistenceContext
    private EntityManager entityManager;
    private Class<E> type;
    public GenericDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    @Transactional
    public void create(E entity) {
        entityManager.persist(entity);
    }

    @Override
    public E findById(Object id) {
        return entityManager.find(type, id);
    }

    @Override
    public List<E> findAll() {
        final StringBuilder strQuery = new StringBuilder("FROM ");
        strQuery.append( type.getName());
        System.out.println("This is the strQuery : " + strQuery);

        TypedQuery<E> query = entityManager.createQuery(strQuery.toString(),type);
        return  query.getResultList();
    }
}
