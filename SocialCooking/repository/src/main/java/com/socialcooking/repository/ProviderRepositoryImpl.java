package com.socialcooking.repository;

import com.socialcooking.domain.Provider;
import com.socialcooking.repository.api.ProviderRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ProviderRepository")
@Repository
@Transactional
public class ProviderRepositoryImpl extends GenericRepositoryImpl<Provider> implements ProviderRepository{


    protected ProviderRepositoryImpl() {
        super(Provider.class);
    }
}
