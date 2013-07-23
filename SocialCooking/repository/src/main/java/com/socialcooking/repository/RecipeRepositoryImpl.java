package com.socialcooking.repository;

import com.socialcooking.domain.Recipe;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mikalai Kisel
 */
@Service("RecipeRepository")
@Repository
@Transactional
public class RecipeRepositoryImpl extends GenericRepositoryImpl<Recipe, Long> implements RecipeRepository{

}
