package com.socialcooking.repository;

import com.socialcooking.domain.Section;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Mikalai Kisel
 */
@Service("SectionRepository")
@Repository
@Transactional
public class SectionRepositoryImpl implements SectionRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly=true)
    public List<Section> findAll() {
        List<Section> sections = em.createNamedQuery("Section.findAll", Section.class).getResultList();
        return sections;
    }
}
