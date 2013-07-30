package com.socialcooking.service;


import com.socialcooking.domain.Ingredient;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.repository.api.IngredientRepository;
import com.socialcooking.service.api.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;

public class IngredientServiceImpl extends GenericServiceImpl<Ingredient> implements IngredientService {

    @Autowired
    private IngredientRepository commentRepository;

    @Override
    protected GenericRepository<Ingredient> getRepository() {
        return commentRepository;
    }

}
