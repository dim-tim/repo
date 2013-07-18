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

/**
 * @author Mikalai Kisel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/datasource-test.xml")
@ActiveProfiles("H2")
public class SectionRepositoryTest {

    @Autowired
    SectionRepository sectionRepository;

    @Test
    public void findAllTest() {
        List<Section> sections = sectionRepository.findAll();
        assertEquals(1, sections.size());
        assertEquals("Салаты", sections.get(0).getName());
    }




}
