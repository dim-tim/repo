package com.socialcooking.repository;

import com.socialcooking.domain.Provider;
import com.socialcooking.domain.User;
import com.socialcooking.repository.api.ProviderRepository;
import com.socialcooking.repository.api.UserRepository;
import org.joda.time.LocalDateTime;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/datasource-test.xml")
//May be H2 or MYSQL
@ActiveProfiles("H2")
@Transactional
public class ProviderRepositoryTest {

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAllTest() {
        List<Provider> providers = providerRepository.findAll();
        assertNotNull(providers);
    }

    @Test
    public void findByIdTest() {
        Provider expectedProvider = new Provider(1L, "Ресторан у дома", "Доставка по Бресту", "Работают проф повара", true, new LocalDateTime("2013-07-19"), 14, 5);
        Provider realProvider = providerRepository.findById(1L);
        assertEquals(expectedProvider, realProvider);
    }

    @Test
    public void saveTest() {
        Provider expectedProvider = new Provider("Ресторан Белая Лошадь", "Доставка по Бресту", "Работают проф повара", true,  new LocalDateTime("2013-07-19"), 14, 5);
        User user = userRepository.findById(1L);
        expectedProvider.setUser(user);

        Provider realProvider = providerRepository.save(expectedProvider);
        assertEquals(expectedProvider, realProvider);
    }

    @Test
    public void updateTest() {
        Provider provider = providerRepository.findById(3L);
        assertEquals("Доставка по Минску", provider.getTermsOfDelivery());

        provider.setTermsOfDelivery("Доставка по Минску и Бресте");
        providerRepository.save(provider);

        provider = providerRepository.findById(3L);
        assertEquals("Доставка по Минску и Бресте", provider.getTermsOfDelivery());
    }

    @Test(expected = javax.persistence.NoResultException.class)
    public void deleteTest() {
        Provider provider = providerRepository.findById(2L);

        providerRepository.delete(provider);

        providerRepository.findById(2L);
    }
}
