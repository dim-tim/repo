package com.socialcooking.repository.api;

import com.socialcooking.domain.Ingredient;

import java.util.List;

/**
 * @author Mikalai Kisel
 */
public interface IngredientRepository extends IGenericRepository<Ingredient> {

    public Ingredient findById(Long id);

    public List<Ingredient> findAll();

    public Ingredient save(Ingredient ingredient);

    public Ingredient update(Ingredient ingredient);

    public void delete(Ingredient ingredient);
}
