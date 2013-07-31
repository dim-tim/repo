package com.socialcooking.repository;

import com.socialcooking.domain.Order;
import com.socialcooking.repository.api.OrderRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class OrderRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void findAllTest() {
        List<Order> orders = orderRepository.findAll();
        assertNotNull(orders);
    }


}
