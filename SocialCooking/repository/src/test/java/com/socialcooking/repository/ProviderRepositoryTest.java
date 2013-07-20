package com.socialcooking.repository;

import com.socialcooking.domain.Provider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.Assert.assertNotNull;

/**
 * @author Mikalai Kisel
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/datasource-test.xml")
//May be H2 or MYSQL
@ActiveProfiles("H2")
public class ProviderRepositoryTest {

    @Autowired
    private ProviderRepository providerRepository;

    @Test
    public void findAllTest() {
        List<Provider> providers = providerRepository.findAll();
        assertNotNull(providers);
    }


}
