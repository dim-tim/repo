package com.socialcooking.service;


import com.socialcooking.domain.Order;
import com.socialcooking.domain.User;
import com.socialcooking.repository.OrderRepositoryImpl;
import com.socialcooking.repository.UserRepositoryImpl;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.repository.api.OrderRepository;
import com.socialcooking.repository.api.UserRepository;
import com.socialcooking.service.api.GenericService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class UserServiceMockTest extends AbstractGenericServiceMockTest<User>{

    @InjectMocks
    private UserServiceImpl userService = new UserServiceImpl();

    @Mock
    private UserRepository userRepository = new UserRepositoryImpl();

    private User user;

    @Override
    protected GenericService<User> getService() {
        return userService;
    }

    @Override
    protected GenericRepository<User> getMockRepository() {
        return userRepository;
    }

    @Override
    protected User getEntity() {
        return user;
    }

    @Before
    public void init() {
        user = new User();
        user.setId(123L);
    }
}
