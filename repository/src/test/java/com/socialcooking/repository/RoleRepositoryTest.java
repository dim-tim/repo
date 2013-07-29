package com.socialcooking.repository;

import com.socialcooking.domain.Role;
import com.socialcooking.repository.api.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Mikalai Kisel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/datasource-test.xml")
//May be H2 or MYSQL
@ActiveProfiles("H2")
@Transactional
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void findAllTest() {
        List<Role> roles = roleRepository.findAll();
        assertNotNull(roles);
    }

    @Test
    public void findByIdTest() {
        Role expectedRole = new Role(1L, "менеджер", "имеет максимальные права");
        Role realRole = roleRepository.findById(1L);
        assertEquals(expectedRole, realRole);
    }
}
