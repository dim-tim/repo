package com.socialcooking.service;


import com.socialcooking.domain.Role;
import com.socialcooking.domain.Section;
import com.socialcooking.repository.RoleRepositoryImpl;
import com.socialcooking.repository.SectionRepositoryImpl;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.repository.api.RoleRepository;
import com.socialcooking.repository.api.SectionRepository;
import com.socialcooking.service.api.GenericService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class SectionServiceMockTest extends AbstractGenericServiceMockTest<Section>{

    @InjectMocks
    private SectionServiceImpl sectionService = new SectionServiceImpl();

    @Mock
    private SectionRepository sectionRepository = new SectionRepositoryImpl();

    private Section section;

    @Override
    protected GenericService<Section> getService() {
        return sectionService;
    }

    @Override
    protected GenericRepository<Section> getMockRepository() {
        return sectionRepository;
    }

    @Override
    protected Section getEntity() {
        return section;
    }

    @Before
    public void init() {
        section = new Section();
        section.setId(123L);
    }
}
