package com.socialcooking.repository.api;

import java.util.List;

/**
 * @author Mikalai Kisel
 */

public interface GenericRepository<T, ID> {

    public T findById(ID id);

    public List<T> findAll();

    public T save(T entity);

    public T update(T entity);

    public void delete(T entity);

    public void deleteById(ID id);

    public void deleteAll();

    public long count();
}
