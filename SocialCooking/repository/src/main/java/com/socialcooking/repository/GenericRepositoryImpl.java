package com.socialcooking.repository;


import com.socialcooking.domain.DomainObject;
import com.socialcooking.repository.api.IGenericRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class GenericRepositoryImpl<T extends DomainObject> implements IGenericRepository<T> {

    private static final String QUERY_COUNT_ALL = "SELECT COUNT(x) FROM %s x";
    private static final String QUERY_SELECT_ALL = "SELECT x FROM %s x";
    private static final String QUERY_SELECT_BY_ID_LIST = "SELECT x FROM %s x WHERE x.id IN (?1)";
    private static final String QUERY_SELECT_BY_ID = "SELECT x FROM %s x WHERE x.id = :id";
    private static final String QUERY_DELETE_BY_ID = "DELETE FROM %s x WHERE x.id = :id";

    @PersistenceContext
    private EntityManager entityManager;

    protected Class<T> persistentClass;

    protected GenericRepositoryImpl(Class<T> persistentClass) {
        super();
        this.persistentClass = persistentClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    protected <REZ> REZ executeQuery(String queryOrQueryName,
                                     boolean namedQuery, boolean singleResult, Object... parameters) {


        if (queryOrQueryName == null) {
            throw new IllegalArgumentException(
                    "Query for executing cannot be null");
        }

        REZ result;
        List<?> list;

        Query query;
        if (namedQuery) {
            query = entityManager.createNamedQuery(queryOrQueryName);
        } else {
            query = entityManager.createQuery(queryOrQueryName);
        }

        if (parameters.length > 0) {
            for (int i = 0; i < parameters.length; i++) {
                query.setParameter(i + 1, parameters[i]);
            }
        }


        if (singleResult) {
            if (query != null) {
                result = (REZ) query.getSingleResult();
            } else {
                result = null;
            }
        } else {
            result = (REZ) query.getResultList();
        }

        return result;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public long getAllEntitiesCount() {
        try {
            return executeQuery(String.format(QUERY_COUNT_ALL, persistentClass.getSimpleName()), false, true);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public T saveOrUpdate(T entity) throws IllegalArgumentException {
        if (entity == null) {
            throw new IllegalArgumentException("Entity for saving cannot be null!");
        }

        if (entity.getId() == null) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }

        return entity;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public T getEntityById(Long id) throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException("id it's null!!!");
        }

        return executeQuery(String.format(QUERY_SELECT_BY_ID, persistentClass.getSimpleName()), false, true);


    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delEntityById(Long id) throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException("id it's null!!!");
        }

        String deleteByIdQuery = String.format(QUERY_DELETE_BY_ID, persistentClass.getSimpleName());

        Query query = entityManager.createQuery(deleteByIdQuery);
        query.setParameter("id", id);

        query.executeUpdate();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delEntity(T entity) throws IllegalArgumentException {
        if (entity == null) {
            throw new IllegalArgumentException("Entity for delete operation cannot be null!");
        }

        T mergedEntity = entityManager.merge(entity);
        entityManager.remove(mergedEntity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delAllEntitiesByIds(Collection<Long> ids) throws IllegalArgumentException {
        if (ids == null) {
            throw new IllegalArgumentException("Collection is null!");
        }

        if (!ids.isEmpty()) {
            for (Long id : ids) {
                T savedEntity = getEntityById(id);
                if (savedEntity != null) {
                    delEntity(savedEntity);
                }
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<T> getAllEntities() {
        List<T> list = executeQuery(String.format(QUERY_SELECT_ALL, persistentClass
                .getSimpleName()), false, false);
        if (list != null)
            return list;
        else
            return new ArrayList<T>();

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<T> getAllSorted(String propertySortBy, boolean asc) throws IllegalArgumentException {
        try {
            String query = String.format(QUERY_SELECT_ALL, persistentClass
                    .getSimpleName());

            String newQuery = addSortPropertyToQuery(query, propertySortBy, asc);

            return executeQuery(newQuery, false, false);
        } catch (Exception e) {
            return new ArrayList<T>();
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<T> getEntitiesByIds(List<Long> ids) throws IllegalArgumentException {
        if (ids == null) {
            throw new IllegalArgumentException("Collection is null!");
        }

        if (ids.isEmpty()) {
            return new ArrayList<T>();
        }

        try {
            return executeQuery(String.format(QUERY_SELECT_BY_ID_LIST,
                    persistentClass.getSimpleName()), false, false, ids);
        } catch (Exception e) {
            return new ArrayList<T>();
        }
    }

    protected String addSortPropertyToQuery(String query, String propertySortBy,
                                            boolean asc) {
        StringBuilder sb = new StringBuilder();
        sb.append(query);
        sb.append(" "); //$NON-NLS-1$
        sb.append("order by "); //$NON-NLS-1$
        sb.append(propertySortBy);

        if (asc) {
            sb.append(" asc"); //$NON-NLS-1$
        } else {
            sb.append(" desc"); //$NON-NLS-1$
        }

        String newQuery = sb.toString();
        return newQuery;
    }

}
