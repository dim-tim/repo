package com.socialcooking.repository;

import com.socialcooking.domain.Delivery;
import com.socialcooking.domain.Provider;
import com.socialcooking.repository.api.DeliveryRepository;
import com.socialcooking.repository.api.ProviderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/datasource-test.xml")
//May be H2 or MYSQL
@ActiveProfiles("H2")
@Transactional
public class DeliveryRepositoryTest {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Test
    public void findAllTest() {
        List<Delivery> deliveries = deliveryRepository.findAll();
        assertNotNull(deliveries);
    }

    @Test
    public void findByIdTest() {
        Delivery expectedDelivery = new Delivery(1L, 20000000, true, 200000000);
        Delivery realDelivery = deliveryRepository.findById(1L);
        assertEquals(expectedDelivery, realDelivery);
    }

    @Test
    public void saveTest() {
        Delivery expectedDelivery = new Delivery(25000, true, 10000);
        Provider provider = providerRepository.findById(1L);
        expectedDelivery.setProvider(provider);

        Delivery realDelivery = deliveryRepository.save(expectedDelivery);
        assertEquals(expectedDelivery, realDelivery);
    }

    @Test
    public void updateTest() {
        Delivery delivery = deliveryRepository.findById(3L);
        assertEquals((Object) 3000, delivery.getPrice());

        delivery.setPrice(4000);
        deliveryRepository.save(delivery);

        delivery = deliveryRepository.findById(3L);
        assertEquals((Object) 4000, delivery.getPrice());
    }

    @Test(expected = javax.persistence.NoResultException.class)
    public void deleteTest() {
        Delivery delivery = deliveryRepository.findById(2L);

        deliveryRepository.delete(delivery);

        deliveryRepository.findById(2L);
    }
}
