package com.socialcooking.repository;

import com.socialcooking.domain.Ingredient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
public class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository ingredientRepository;

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
