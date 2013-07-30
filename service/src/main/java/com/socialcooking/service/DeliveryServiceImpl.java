package com.socialcooking.service;


import com.socialcooking.domain.Delivery;
import com.socialcooking.repository.api.DeliveryRepository;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.service.api.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;

public class DeliveryServiceImpl extends GenericServiceImpl<Delivery> implements DeliveryService {

    @Autowired
    private DeliveryRepository commentRepository;

    @Override
    protected GenericRepository<Delivery> getRepository() {
        return commentRepository;
    }

}
