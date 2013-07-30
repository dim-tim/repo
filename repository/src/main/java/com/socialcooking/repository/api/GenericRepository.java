package com.socialcooking.repository.api;

import com.socialcooking.domain.DomainObject;

import java.util.List;


public interface GenericRepository<T extends DomainObject> {

    public T findById(Long id);

    public List<T> findAll();

    public T save(T entity);

    public void delete(T entity);

    public void deleteById(Long id);

    public void deleteAll();

    public long count();
}
