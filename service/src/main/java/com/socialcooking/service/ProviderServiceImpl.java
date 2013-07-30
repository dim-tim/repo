package com.socialcooking.service;


import com.socialcooking.domain.Provider;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.repository.api.ProviderRepository;
import com.socialcooking.service.api.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("providerService")
@Transactional
public class ProviderServiceImpl extends GenericServiceImpl<Provider> implements ProviderService {

    @Autowired
    private ProviderRepository commentRepository;

    @Override
    protected GenericRepository<Provider> getRepository() {
        return commentRepository;
    }

}
