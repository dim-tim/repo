package com.socialcooking.service;


import com.socialcooking.domain.DomainObject;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.service.api.GenericService;

import java.util.List;

public abstract class GenericServiceImpl<T extends DomainObject> implements GenericService<T> {

    protected abstract GenericRepository<T> getRepository();

    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public void deleteById(Long id) {
        getRepository().deleteById(id);
    }

    @Override
    public void delete(T entity) {
        getRepository().delete(entity);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }

    @Override
    public T findById(Long id) {
        return getRepository().findById(id);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public long count() {
        return getRepository().count();
    }
}
