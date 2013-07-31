package com.socialcooking.service;


import com.socialcooking.domain.Provider;
import com.socialcooking.repository.ProviderRepositoryImpl;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.repository.api.ProviderRepository;
import com.socialcooking.service.api.GenericService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ProviderServiceMockTest extends AbstractGenericServiceMockTest<Provider>{

    @InjectMocks
    private ProviderServiceImpl providerService = new ProviderServiceImpl();

    @Mock
    private ProviderRepository providerRepository = new ProviderRepositoryImpl();

    private Provider provider;

    @Override
    protected GenericService<Provider> getService() {
        return providerService;
    }

    @Override
    protected GenericRepository<Provider> getMockRepository() {
        return providerRepository;
    }

    @Override
    protected Provider getEntity() {
        return provider;
    }

    @Before
    public void init() {
        provider = new Provider();
        provider.setId(123L);
    }
}
