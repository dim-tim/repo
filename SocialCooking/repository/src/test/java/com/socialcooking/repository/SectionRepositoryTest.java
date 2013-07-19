package com.socialcooking.repository;

import com.socialcooking.domain.Section;
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
public class SectionRepositoryTest {

    @Autowired
    private SectionRepository sectionRepository;

    @Test
    public void findAllTest() {
        List<Section> sections = sectionRepository.findAll();
        assertNotNull(sections);
    }

    @Test()
    public void findByIdTest() {
        Section section = sectionRepository.findById("Салаты");
        assertEquals("Салаты", section.getName());
        assertEquals("Легкая закуска", section.getDescription());
    }

    @Test
    public void saveTest() {
        Section expectedSection = new Section("Основные блюда", "Большие по объему");
        Section realSection = sectionRepository.save(expectedSection);
        assertEquals(expectedSection, realSection);
        realSection = sectionRepository.findById("Основные блюда");
        assertEquals(expectedSection, realSection);
    }

    @Test(expected = javax.persistence.NoResultException.class)
    public void deleteTest() {
        Section expectedSection = new Section("Супы", "");
        Section realSection = sectionRepository.findById("Супы");
        assertEquals(expectedSection, realSection);

        sectionRepository.delete(realSection);

        realSection = sectionRepository.findById("Супы");
        assertEquals(null, realSection);
    }

    @Test
    public void updateTest() {
        Section realSection = sectionRepository.findById("Напитки");
        assertEquals("", realSection.getDescription());

        realSection.setDescription("Очень вкусные");
        sectionRepository.update(realSection);

        realSection = sectionRepository.findById("Напитки");
        assertEquals("Очень вкусные", realSection.getDescription());
    }


}
