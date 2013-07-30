package com.socialcooking.service;


import com.socialcooking.domain.Order;
import com.socialcooking.domain.Role;
import com.socialcooking.repository.OrderRepositoryImpl;
import com.socialcooking.repository.RoleRepositoryImpl;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.repository.api.OrderRepository;
import com.socialcooking.repository.api.RoleRepository;
import com.socialcooking.service.api.GenericService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class RoleServiceMockTest extends AbstractGenericServiceMockTest<Role>{

    @InjectMocks
    private RoleServiceImpl roleService = new RoleServiceImpl();

    @Mock
    private RoleRepository roleRepository = new RoleRepositoryImpl();

    private Role role;

    @Override
    protected GenericService<Role> getService() {
        return roleService;
    }

    @Override
    protected GenericRepository<Role> getMockRepository() {
        return roleRepository;
    }

    @Override
    protected Role getEntity() {
        return role;
    }

    @Before
    public void init() {
        role = new Role();
        role.setId(123L);
    }
}
