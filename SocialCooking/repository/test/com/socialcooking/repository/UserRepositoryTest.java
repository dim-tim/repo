package com.socialcooking.repository;

import com.socialcooking.domain.Role;
import com.socialcooking.domain.User;
import com.socialcooking.repository.api.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

import static junit.framework.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-datasource.xml")
@ActiveProfiles("H2")
public class UserRepositoryTest {


    @Autowired
    private UserRepository userRepositoryImpl;

    @Test
    public void findAllTest() {
        List<User> users = userRepositoryImpl.getAllEntities();
        assertNotNull(users);
        Set<Role> roles = users.get(0).getRoles();
        for (Role role : roles)
            System.out.println(role);
    }
}

