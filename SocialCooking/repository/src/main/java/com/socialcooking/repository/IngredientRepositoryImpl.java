package com.socialcooking.repository;

import com.socialcooking.domain.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Mikalai Kisel
 */

@Service("IngredientRepository")
@Repository
@Transactional
public class IngredientRepositoryImpl implements IngredientRepository{

    @PersistenceContext
    private EntityManager em;

    private Logger log = LoggerFactory.getLogger(IngredientRepositoryImpl.class);

    @Override
    public Ingredient findById(Long id) {
        log.info("Find ingredient by id");
        TypedQuery<Ingredient> query = em.createNamedQuery("Ingredient.findById", Ingredient.class);
        query.setParameter("id", id);
        Ingredient ingredient = query.getSingleResult();
        return ingredient;
    }

    @Override
    public List<Ingredient> findAll() {
        log.info("Find all ingredients");
        List<Ingredient> ingredients = em.createNamedQuery("Ingredient.findAll", Ingredient.class).getResultList();
        return ingredients;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        log.info("Save new ingredient");
        em.persist(ingredient);
        return ingredient;
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        log.info("Update ingredient");
        em.merge(ingredient);
        return ingredient;
    }

    @Override
    public void delete(Ingredient ingredient) {
        log.info("Delete ingredient");
        Ingredient mergedIngredient = em.merge(ingredient);
        em.remove(mergedIngredient);
    }
}
