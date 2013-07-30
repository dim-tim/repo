package com.socialcooking.service;


import com.socialcooking.domain.Section;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.repository.api.SectionRepository;
import com.socialcooking.service.api.SectionService;
import org.springframework.beans.factory.annotation.Autowired;

public class SectionServiceImpl extends GenericServiceImpl<Section> implements SectionService {

    @Autowired
    private SectionRepository commentRepository;

    @Override
    protected GenericRepository<Section> getRepository() {
        return commentRepository;
    }

}
