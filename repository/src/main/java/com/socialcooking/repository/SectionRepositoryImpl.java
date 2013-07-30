package com.socialcooking.repository;

import com.socialcooking.domain.Section;
import com.socialcooking.repository.api.SectionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SectionRepositoryImpl extends GenericRepositoryImpl<Section> implements SectionRepository {

    private Logger log = LoggerFactory.getLogger(SectionRepositoryImpl.class);


}
