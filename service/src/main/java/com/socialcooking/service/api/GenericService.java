package com.socialcooking.service.api;


import com.socialcooking.domain.DomainObject;

import java.util.List;

public interface GenericService<T extends DomainObject> {

    public T save(T entity);

    public void deleteById(Long id);

    public void delete(T entity);

    public void deleteAll();

    public T findById(Long id);

    public List<T> findAll();

    public long count();
}
