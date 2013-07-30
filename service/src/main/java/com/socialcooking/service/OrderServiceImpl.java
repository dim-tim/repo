package com.socialcooking.service;

import com.socialcooking.domain.Order;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.repository.api.OrderRepository;
import com.socialcooking.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
@Transactional
public class OrderServiceImpl extends GenericServiceImpl<Order> implements OrderService {

    @Autowired
    private OrderRepository commentRepository;

    @Override
    protected GenericRepository<Order> getRepository() {
        return commentRepository;
    }

}
