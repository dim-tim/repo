package com.socialcooking.repository;

import com.socialcooking.domain.Section;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * @author Mikalai Kisel
 */
public class SectionRepositoryTest {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:datasource.xml");
        ctx.refresh();
        SectionRepository sectionRepository = ctx.getBean(
                "SectionRepository", SectionRepository.class);
// List contacts without details
        List<Section> contacts = sectionRepository.findAll();
//        listContacts(contacts);
    }
//    private static void listContacts(List<Contact> contacts) {
//        System.out.println("");
//        System.out.println("Listing contacts without details:");
//        for (Contact contact: contacts) {
//            System.out.println(contact);
//            System.out.println();
//        }
//
//    }
}
