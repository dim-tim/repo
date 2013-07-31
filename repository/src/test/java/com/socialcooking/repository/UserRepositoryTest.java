package com.socialcooking.repository;

import com.socialcooking.domain.Role;
import com.socialcooking.domain.User;
import com.socialcooking.repository.api.RoleRepository;
import com.socialcooking.repository.api.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;

public class UserRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void findAllTest() {
        List<User> users = userRepository.findAll();
        assertNotNull(users);

        Set<Role> roles = users.get(0).getRoles();

    }
}
