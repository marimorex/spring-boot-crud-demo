package com.demo.cruddemo.dao;

public interface GenericDAO<ENTITY> {

    void save(ENTITY theEntity);
}
