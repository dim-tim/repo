package com.socialcooking.service;

import com.socialcooking.domain.Order;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.repository.api.OrderRepository;
import com.socialcooking.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl extends GenericServiceImpl<Order> implements OrderService {

    @Autowired
    private OrderRepository commentRepository;

    @Override
    protected GenericRepository<Order> getRepository() {
        return commentRepository;
    }

}
