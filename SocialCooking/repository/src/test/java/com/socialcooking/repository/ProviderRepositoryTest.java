package com.socialcooking.repository;

import com.socialcooking.domain.Provider;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.Assert.assertEquals;
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
    private ProviderRepositoryImpl providerRepository;

    @Test
    public void findAllTest() {
        List<Provider> providers = providerRepository.findAll();
        assertNotNull(providers);
    }

    @Test
    public void findByIdTest() {
        Provider expectedProvider = new Provider("Ресторан у дома", "Доставка по Бресту", true, "Работают проф повара", new LocalDateTime("2013-07-19"), 14, 5);
        Provider realProvider = providerRepository.findById("Ресторан у дома");
        assertEquals(expectedProvider, realProvider);
    }

    @Test
    public void saveTest() {
        Provider expectedProvider = new Provider("Ресторан Белая Лошадь", "Доставка по Бресту", true, "Работают проф повара", new LocalDateTime("2013-07-19"), 14, 5);
        Provider realProvider = providerRepository.save(expectedProvider);
        assertEquals(expectedProvider, realProvider);
    }

    @Test
    public void updateTest() {
        Provider provider = providerRepository.findById("Ресторан Дружба");
        assertEquals("Доставка по Минску", provider.getTermsOfDelivery());

        provider.setTermsOfDelivery("Доставка по Минску и Бресте");
        providerRepository.update(provider);

        provider = providerRepository.findById("Ресторан Дружба");
        assertEquals("Доставка по Минску и Бресте", provider.getTermsOfDelivery());
    }

    @Test(expected = javax.persistence.NoResultException.class)
    public void deleteTest() {
        Provider provider = providerRepository.findById("Националь");

        providerRepository.delete(provider);

        providerRepository.findById("Националь");
    }
}
