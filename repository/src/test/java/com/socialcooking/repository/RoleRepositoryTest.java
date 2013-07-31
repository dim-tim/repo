package com.socialcooking.repository;

import com.socialcooking.domain.Role;
import com.socialcooking.repository.api.RoleRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RoleRepositoryTest extends AbstractRepositoryTest {

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
