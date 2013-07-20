package com.socialcooking.repository;

import com.socialcooking.domain.Ingredient;
import com.socialcooking.domain.Provider;

import java.util.List;

/**
 * @author Mikalai Kisel
 */
public interface ProviderRepository {

    public Provider findById(Long id);

    public List<Provider> findAll();

    public Provider save(Provider provider);

    public Provider update(Provider provider);

    public void delete(Provider provider);
}
