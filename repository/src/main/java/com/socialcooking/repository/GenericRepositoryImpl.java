package com.socialcooking.repository;

import com.socialcooking.domain.DomainObject;
import com.socialcooking.repository.api.GenericRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
public class GenericRepositoryImpl<T extends DomainObject> implements GenericRepository<T> {

    @PersistenceContext
    private EntityManager em;

    private Logger log = LoggerFactory.getLogger(GenericRepository.class);

    protected Class<T> persistentClass;

    private static final String QUERY_SELECT_BY_ID = "SELECT x FROM %s x WHERE x.id = :id";
    private static final String QUERY_SELECT_ALL = "SELECT x FROM %s x";
    private static final String QUERY_DELETE_BY_ID = "DELETE FROM %s x WHERE x.id = :id";
    private static final String QUERY_DELETE_ALL = "DELETE FROM %s";
    private static final String QUERY_COUNT_ALL = "SELECT COUNT(id) FROM %s";


    public GenericRepositoryImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public T findById(Long id) {
        String findByIdQuery = String.format(QUERY_SELECT_BY_ID, persistentClass.getSimpleName());

        Query query = em.createQuery(findByIdQuery);
        query.setParameter("id", id);

        return (T) query.getSingleResult();
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<T> findAll() {
        String findAllQuery = String.format(QUERY_SELECT_ALL, persistentClass.getSimpleName());

        Query query = em.createQuery(findAllQuery);

        return query.getResultList();
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public T save(T entity) {
        if (entity.getId() == null)
            em.persist(entity);
        else
            em.merge(entity);
        return entity;
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(T entity) {
        T mergedEntity = em.merge(entity);
        em.remove(mergedEntity);
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteById(Long id) {
        String deleteByIdQuery = String.format(QUERY_DELETE_BY_ID, persistentClass.getSimpleName());

        Query query = em.createQuery(deleteByIdQuery);
        query.setParameter("id", id);

        query.executeUpdate();
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteAll() {
        String deleteAllQuery = String.format(QUERY_DELETE_ALL, persistentClass.getSimpleName());

        Query query = em.createQuery(deleteAllQuery);
        query.executeUpdate();
    }

    @Override
//    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public long count() {
        String countRowQuery = String.format(QUERY_COUNT_ALL, persistentClass.getSimpleName());

        Query query = em.createQuery(countRowQuery);

        return (Long) query.getSingleResult();
    }
}
