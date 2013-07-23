package com.socialcooking.repository;

import com.socialcooking.domain.Ingredient;
import com.socialcooking.repository.api.IngredientRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("IngredientRepository")
@Repository
@Transactional
public class IngredientRepositoryImpl extends GenericRepositoryImpl<Ingredient> implements IngredientRepository {


    protected IngredientRepositoryImpl() {
        super(Ingredient.class);
    }
}
