package com.socialcooking.repository;

import com.socialcooking.domain.Delivery;
import com.socialcooking.repository.api.DeliveryRepository;
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

@Service("DeliveryRepository")
@Repository
@Transactional
public class DeliveryRepositoryImpl implements DeliveryRepository {

    @PersistenceContext
    private EntityManager em;

    private Logger log = LoggerFactory.getLogger(DeliveryRepositoryImpl.class);

    @Override
    @Transactional(readOnly=true)
    public Delivery findById(Long id) {
        log.info("Find delivery by id");
        TypedQuery<Delivery> query = em.createNamedQuery("Delivery.findById", Delivery.class);
        query.setParameter("id", id);
        Delivery delivery = query.getSingleResult();
        return delivery;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Delivery> findAll() {
        log.info("Find all deliveries");
        List<Delivery> deliveries = em.createNamedQuery("Delivery.findAll", Delivery.class).getResultList();
        return deliveries;
    }

    @Override
    public Delivery save(Delivery delivery) {
        log.info("Save new delivery");
        em.persist(delivery);
        return delivery;
    }

    @Override
    public Delivery update(Delivery delivery) {
        log.info("Update delivery");
        em.merge(delivery);
        return delivery;
    }

    @Override
    public void delete(Delivery delivery) {
        log.info("Delete delivery");
        Delivery mergedDelivery = em.merge(delivery);
        em.remove(mergedDelivery);
    }
}
