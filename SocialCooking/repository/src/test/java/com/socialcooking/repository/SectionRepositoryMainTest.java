package com.socialcooking.repository;

import com.socialcooking.domain.Section;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * @author Mikalai Kisel
 */
public class SectionRepositoryMainTest {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:datasource.xml");
        ctx.refresh();
        SectionRepository sectionRepository = ctx.getBean(
                "SectionRepository", SectionRepository.class);

        List<Section> sections = sectionRepository.findAll();
        printSections(sections);

    }

    public static void printSections(List<Section> sections) {
        for (Section section: sections)
            System.out.println(section);
    }

}
