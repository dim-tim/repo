package com.socialcooking.repository;

import com.socialcooking.domain.User;
import com.socialcooking.repository.api.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * @author Mikalai Kisel
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/datasource-test.xml")
//May be H2 or MYSQL. MySQL is not work.
@ActiveProfiles("H2")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAllTest() {
        List<User> users = userRepository.findAll();
        assertNotNull(users);
    }
}
