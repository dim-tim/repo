package com.socialcooking.repository.api;


import java.util.Collection;
import java.util.List;

public interface IGenericRepository<T> {

    public T saveOrUpdate(T entity)
            throws IllegalArgumentException;

    public void delEntity(Long id)
            throws IllegalArgumentException;

    public void delEntity(T entity)
            throws IllegalArgumentException;

    public void delAllEntities(Collection<Long> ids)
            throws IllegalArgumentException;

    public T getEntityById(Long id)
            throws IllegalArgumentException;

    public List<T> getAllEntities();

    public List<T> getEntitiesByIds(List<Long> ids)
            throws IllegalArgumentException;

    public long getAllEntitiesCount();

    public List<T> getAllSorted(String propertySortBy, boolean asc)
            throws IllegalArgumentException;
}
