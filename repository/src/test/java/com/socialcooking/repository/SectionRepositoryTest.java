package com.socialcooking.repository;

import com.socialcooking.domain.Recipe;
import com.socialcooking.domain.Section;
import com.socialcooking.repository.api.SectionRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SectionRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private SectionRepository sectionRepository;

    @Test
    public void findAllTest() {
        List<Section> sections = sectionRepository.findAll();
        assertNotNull(sections);
    }

    @Test()
    public void findByIdTest() {
        Section section = sectionRepository.findById(1L);
        assertEquals("Салаты", section.getName());
        assertEquals("Легкая закуска", section.getDescription());
        Set<Recipe> recipes = section.getRecipes();
        assertNotNull(recipes);
    }

    @Test
    public void saveTest() {
        Section expectedSection = new Section("Основные блюда", "Большие по объему");
        Section realSection = sectionRepository.save(expectedSection);
        assertEquals(expectedSection, realSection);

    }

    @Test(expected = javax.persistence.NoResultException.class)
    public void deleteTest() {
        Section expectedSection = new Section("Супы", "");
        Section realSection = sectionRepository.findById(2L);
        assertEquals(expectedSection, realSection);

        sectionRepository.delete(realSection);

        realSection = sectionRepository.findById(2L);
        assertEquals(null, realSection);
    }

    @Test
    public void updateTest() {
        Section realSection = sectionRepository.findById(3L);
        assertEquals("", realSection.getDescription());

        realSection.setDescription("Очень вкусные");
        sectionRepository.save(realSection);

        realSection = sectionRepository.findById(3L);
        assertEquals("Очень вкусные", realSection.getDescription());
    }


}
