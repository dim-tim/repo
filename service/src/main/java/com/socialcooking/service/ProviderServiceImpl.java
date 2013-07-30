package com.socialcooking.service;


import com.socialcooking.domain.Provider;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.repository.api.ProviderRepository;
import com.socialcooking.service.api.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProviderServiceImpl extends GenericServiceImpl<Provider> implements ProviderService {

    @Autowired
    private ProviderRepository commentRepository;

    @Override
    protected GenericRepository<Provider> getRepository() {
        return commentRepository;
    }

}
