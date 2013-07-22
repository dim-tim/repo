package com.socialcooking.repository;

import com.socialcooking.domain.Provider;
import com.socialcooking.repository.api.ProviderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Mikalai Kisel
 */
@Service("ProviderRepository")
@Repository
@Transactional
public class ProviderRepositoryImpl implements ProviderRepository {

    @PersistenceContext
    private EntityManager em;

    private Logger log = LoggerFactory.getLogger(IngredientRepositoryImpl.class);

    @Override
    @Transactional(readOnly=true)
    public Provider findById(Long id) {
        log.info("Find provider by id");
        TypedQuery<Provider> query = em.createNamedQuery("Provider.findById", Provider.class);
        Provider provider = query.getSingleResult();
        return provider;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Provider> findAll() {
        log.info("Find all providers");
        List<Provider> providers = em.createNamedQuery("Provider.findAll", Provider.class).getResultList();
        return providers;
    }

    @Override
    public Provider save(Provider provider) {
        log.info("Save new provider");
        em.persist(provider);
        return provider;
    }

    @Override
    public Provider update(Provider provider) {
        log.info("Update provider");
        em.merge(provider);
        return provider;
    }

    @Override
    public void delete(Provider provider) {
        log.info("Delete provider");
        Provider mergedProvider = em.merge(provider);
        em.remove(mergedProvider);
    }
}
