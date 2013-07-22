package com.socialcooking.repository;

import com.socialcooking.domain.Section;
import com.socialcooking.repository.api.SectionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Mikalai Kisel
 */

@Service("SectionRepository")
@Repository
@Transactional
public class SectionRepositoryImpl implements SectionRepository {

    @PersistenceContext
    private EntityManager em;

    private Logger log = LoggerFactory.getLogger(SectionRepositoryImpl.class);

    @Override
    @Transactional(readOnly=true)
    public Section findById(String name) {
        log.info("Find section by id {}", name);
        TypedQuery<Section> query = em.createNamedQuery("Section.findById", Section.class);
        query.setParameter("name", name);
        Section section = query.getSingleResult();
        return section;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Section> findAll() {
        log.info("Find all sections");
        List<Section> sections = em.createNamedQuery("Section.findAll", Section.class).getResultList();
        return sections;
    }

    @Override
    public Section save(Section section) {
        log.info("Insert new section");
        em.persist(section);
        return section;
    }

    @Override
    public Section update(Section section) {
        log.info("Update section with name "+section.getName());
        em.merge(section);
        return section;
    }

    @Override
    public void delete(Section section) {
        log.info("Delete section with name "+section.getName());
        Section mergedSection = em.merge(section);
        em.remove(mergedSection);
    }
}
