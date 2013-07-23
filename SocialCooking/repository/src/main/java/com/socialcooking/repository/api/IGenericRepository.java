package com.socialcooking.repository.api;


import com.socialcooking.domain.DomainObject;

import java.util.Collection;
import java.util.List;

public interface IGenericRepository<T extends DomainObject> {

    public T saveOrUpdate(T entity)
            throws IllegalArgumentException;

    public void delEntityById(Long id)
            throws IllegalArgumentException;

    public void delEntity(T entity)
            throws IllegalArgumentException;

    public void delAllEntitiesByIds(Collection<Long> ids)
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
