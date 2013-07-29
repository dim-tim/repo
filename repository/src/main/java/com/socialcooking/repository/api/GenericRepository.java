package com.socialcooking.repository.api;

import java.util.List;

/**
 * @author Mikalai Kisel
 */

public interface GenericRepository<T> {

    public T findById(Long id);

    public List<T> findAll();

    public T save(T entity);

    public T update(T entity);

    public void delete(T entity);

    public void deleteById(Long id);

    public void deleteAll();

    public long count();
}
