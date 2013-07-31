package com.socialcooking.service;


import com.socialcooking.domain.Comment;
import com.socialcooking.domain.Delivery;
import com.socialcooking.repository.CommentRepositoryImpl;
import com.socialcooking.repository.DeliveryRepositoryImpl;
import com.socialcooking.repository.api.CommentRepository;
import com.socialcooking.repository.api.DeliveryRepository;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.service.api.GenericService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class DeliveryServiceMockTest extends AbstractGenericServiceMockTest<Delivery> {

    @InjectMocks
    private DeliveryServiceImpl deliveryService = new DeliveryServiceImpl();

    @Mock
    private DeliveryRepository deliveryRepository = new DeliveryRepositoryImpl();

    private Delivery delivery;

    @Override
    protected GenericService<Delivery> getService() {
        return deliveryService;
    }

    @Override
    protected GenericRepository<Delivery> getMockRepository() {
        return deliveryRepository;
    }

    @Override
    protected Delivery getEntity() {
        return delivery;
    }

    @Before
    public void init() {
        delivery = new Delivery();
        delivery.setId(123L);
    }
}
