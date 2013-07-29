package com.socialcooking.repository;

import com.socialcooking.domain.Ingredient;
import com.socialcooking.domain.Recipe;
import com.socialcooking.repository.api.IngredientRepository;
import com.socialcooking.repository.api.RecipeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * @author Mikalai Kisel
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/datasource-test.xml")
//May be H2 or MYSQL
@ActiveProfiles("H2")
@Transactional
public class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    public void findByIdTest() {
        Ingredient expectedIngredient = new Ingredient(1L, "Картофель", "", "100 грамм");
        Ingredient realIngredient = ingredientRepository.findById(1L);
        assertEquals(expectedIngredient, realIngredient);
    }

    @Test
    public void findAllTest() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        assertNotNull(ingredients);
    }

    @Test
    public void saveTest() {
        Ingredient expectedIngredient = new Ingredient("Картофель", "", "500 грамм");
        Recipe recipe = recipeRepository.findById(1L);
        expectedIngredient.setRecipe(recipe);

        Ingredient realIngredient = ingredientRepository.save(expectedIngredient);
        assertEquals(expectedIngredient, realIngredient);
    }

    @Test
    public void updateTest() {
        Ingredient ingredient = ingredientRepository.findById(3L);
        assertEquals("Масло", ingredient.getName());

        ingredient.setName("Сыр");
        ingredientRepository.update(ingredient);

        ingredient = ingredientRepository.findById(3L);
        assertEquals("Сыр", ingredient.getName());
    }

    @Test(expected = javax.persistence.NoResultException.class)
    public void deleteTest() {
        Ingredient ingredient = ingredientRepository.findById(2L);

        ingredientRepository.delete(ingredient);

        ingredientRepository.findById(2L);
    }
}
