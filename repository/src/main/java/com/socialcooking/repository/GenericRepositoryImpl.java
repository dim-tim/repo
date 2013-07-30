package com.socialcooking.repository;

import com.socialcooking.domain.DomainObject;
import com.socialcooking.repository.api.GenericRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    String genericFindByIdQuery = "SELECT x FROM %s x WHERE x.id = :id";
    String genericFindAllQuery = "SELECT x FROM %s x";
    String genericDeleteByIdQuery = "DELETE FROM %s x WHERE x.id = :id";
    String genericDeleteAllQuery = "DELETE FROM %s";
    String genericCountRowQuery = "SELECT COUNT(id) FROM %s";


    public GenericRepositoryImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(Long id) {
        String findByIdQuery = String.format(genericFindByIdQuery, persistentClass.getSimpleName());

        Query query = em.createQuery(findByIdQuery);
        query.setParameter("id", id);

        return (T) query.getSingleResult();
    }


    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        String findAllQuery = String.format(genericFindAllQuery, persistentClass.getSimpleName());

        Query query = em.createQuery(findAllQuery);

        return query.getResultList();
    }

    @Override
    public T save(T entity) {
        if (entity.getId()==null)
            em.persist(entity);
        else
            em.merge(entity);
        return entity;
    }

//    @Override
//    public T update(T entity) {
//        em.merge(entity);
//        return entity;
//
//    }

    @Override
    public void delete(T entity) {
        T mergedEntity = em.merge(entity);
        em.remove(mergedEntity);
    }

    @Override
    public void deleteById(Long id) {
        String deleteByIdQuery = String.format(genericDeleteByIdQuery, persistentClass.getSimpleName());

        Query query = em.createQuery(deleteByIdQuery);
        query.setParameter("id", id);

        query.executeUpdate();
    }

    @Override
    public void deleteAll() {
        String deleteAllQuery = String.format(genericDeleteAllQuery, persistentClass.getSimpleName());

        Query query = em.createQuery(deleteAllQuery);
        query.executeUpdate();
    }

    @Override
    public long count() {
        String countRowQuery = String.format(genericCountRowQuery, persistentClass.getSimpleName());

        Query query = em.createQuery(countRowQuery);

        return (Long) query.getSingleResult();
    }
}
