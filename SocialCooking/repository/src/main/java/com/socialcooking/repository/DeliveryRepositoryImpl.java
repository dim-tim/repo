package com.socialcooking.repository;

import com.socialcooking.domain.Delivery;
import com.socialcooking.repository.api.DeliveryRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("DeliveryRepository")
@Repository
@Transactional
public class DeliveryRepositoryImpl extends GenericRepositoryImpl<Delivery> implements DeliveryRepository {


    protected DeliveryRepositoryImpl() {
        super(Delivery.class);
    }
}
