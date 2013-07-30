package com.socialcooking.service;


import com.socialcooking.domain.Ingredient;
import com.socialcooking.domain.Order;
import com.socialcooking.repository.IngredientRepositoryImpl;
import com.socialcooking.repository.OrderRepositoryImpl;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.repository.api.IngredientRepository;
import com.socialcooking.repository.api.OrderRepository;
import com.socialcooking.service.api.GenericService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class OrderServiceMockTest extends AbstractGenericServiceMockTest<Order>{

    @InjectMocks
    private OrderServiceImpl orderService = new OrderServiceImpl();

    @Mock
    private OrderRepository orderRepository = new OrderRepositoryImpl();

    private Order order;

    @Override
    protected GenericService<Order> getService() {
        return orderService;
    }

    @Override
    protected GenericRepository<Order> getMockRepository() {
        return orderRepository;
    }

    @Override
    protected Order getEntity() {
        return order;
    }

    @Before
    public void init() {
        order = new Order();
        order.setId(123L);
    }
}
