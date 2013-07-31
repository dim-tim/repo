package com.socialcooking.repository;

import com.socialcooking.domain.Order;
import com.socialcooking.repository.api.OrderRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OrderRepositoryImpl extends GenericRepositoryImpl<Order> implements OrderRepository{
}
