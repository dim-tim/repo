package com.socialcooking.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author Mikalai Kisel
 */


public class GenericRepositoryImpl<T, ID>  {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private JpaTransactionManager tm;

    private Logger log = LoggerFactory.getLogger(GenericRepository.class);

    protected Class<T> persistentClass;

    String genericFindByIdQuery = "SELECT x FROM %s x WHERE x.id = :id";
    String genericFindAllQuery = "SELECT x FROM %s x";


    public GenericRepositoryImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void setPersistentClass(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

//    @Override
    public T findById(ID id) {
        String findByIdQuery = String.format(genericFindByIdQuery, persistentClass.getSimpleName());

        Query query = em.createQuery(findByIdQuery);
        query.setParameter("id", id);

        return (T) query.getSingleResult();
    }

//    @Override
    public List<T> findAll() {
        String findAllQuery = String.format(genericFindAllQuery, persistentClass.getSimpleName());

        Query query = em.createQuery(findAllQuery);

        return query.getResultList();
    }

//    @Override
    public T save(T entity) {
        TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());
        em.persist(entity);
        tm.commit(status);
        return entity;
    }

//    @Override
    public T update(T entity) {
        TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());
        em.merge(entity);
        tm.commit(status);
        return entity;

    }

//    @Override
    public void delete(T entity) {
        TransactionStatus status = tm.getTransaction(new DefaultTransactionDefinition());
        T mergedEntity = em.merge(entity);
        em.remove(mergedEntity);
        tm.commit(status);
    }
}
