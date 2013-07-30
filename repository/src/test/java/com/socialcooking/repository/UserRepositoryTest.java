package com.socialcooking.repository;

import com.socialcooking.domain.Role;
import com.socialcooking.domain.User;
import com.socialcooking.repository.api.RoleRepository;
import com.socialcooking.repository.api.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/datasource-test.xml")
//May be H2 or MYSQL. MySQL is not work.
@ActiveProfiles("H2")
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void findAllTest() {
        List<User> users = userRepository.findAll();
        assertNotNull(users);

        Set<Role> roles =  users.get(0).getRoles();

    }
}
