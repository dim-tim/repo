package com.socialcooking.repository.api;


import java.util.Collection;
import java.util.List;

public interface IGenericRepository<T, K> {

    public T save(T entity)
            throws IllegalArgumentException;

    public T update(T entity)
            throws IllegalArgumentException;

    public void delEntityById(K id)
            throws IllegalArgumentException;

    public void delEntity(T entity)
            throws IllegalArgumentException;

    public void delAllEntitiesByIds(Collection<K> ids)
            throws IllegalArgumentException;

    public T getEntityById(K id)
            throws IllegalArgumentException;

    public List<T> getAllEntities();

    public List<T> getEntitiesByIds(List<K> ids)
            throws IllegalArgumentException;

    public long getAllEntitiesCount();

    public List<T> getAllSorted(String propertySortBy, boolean asc)
            throws IllegalArgumentException;
}
