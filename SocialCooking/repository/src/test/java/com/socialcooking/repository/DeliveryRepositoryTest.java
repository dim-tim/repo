package com.socialcooking.repository;

import com.socialcooking.domain.Delivery;
import com.socialcooking.repository.api.DeliveryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Mikalai Kisel
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/datasource-test.xml")
//May be H2 or MYSQL
@ActiveProfiles("H2")
public class DeliveryRepositoryTest {

    @Autowired
    private DeliveryRepository deliveryRepository;

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
        Delivery realDelivery = deliveryRepository.save(expectedDelivery);
        assertEquals(expectedDelivery, realDelivery);
    }

    @Test
    public void updateTest() {
        Delivery delivery = deliveryRepository.findById(3L);
        assertEquals((Object) 3000, delivery.getPrice());

        delivery.setPrice(4000);
        deliveryRepository.update(delivery);

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
