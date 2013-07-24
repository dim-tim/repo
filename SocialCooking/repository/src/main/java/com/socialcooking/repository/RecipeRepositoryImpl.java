package com.socialcooking.repository;

import com.socialcooking.domain.Recipe;
import com.socialcooking.repository.api.RecipeRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("RecipeRepository")
@Repository
@Transactional
public class RecipeRepositoryImpl extends GenericRepositoryImpl<Recipe> implements RecipeRepository {

    protected RecipeRepositoryImpl() {
        super(Recipe.class);
    }
}
