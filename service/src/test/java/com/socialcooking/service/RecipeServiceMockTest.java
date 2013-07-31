package com.socialcooking.service;


import com.socialcooking.domain.Order;
import com.socialcooking.domain.Recipe;
import com.socialcooking.repository.OrderRepositoryImpl;
import com.socialcooking.repository.RecipeRepositoryImpl;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.repository.api.OrderRepository;
import com.socialcooking.repository.api.RecipeRepository;
import com.socialcooking.service.api.GenericService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class RecipeServiceMockTest extends AbstractGenericServiceMockTest<Recipe>{

    @InjectMocks
    private RecipeServiceImpl recipeService = new RecipeServiceImpl();

    @Mock
    private RecipeRepository recipeRepository = new RecipeRepositoryImpl();

    private Recipe recipe;

    @Override
    protected GenericService<Recipe> getService() {
        return recipeService;
    }

    @Override
    protected GenericRepository<Recipe> getMockRepository() {
        return recipeRepository;
    }

    @Override
    protected Recipe getEntity() {
        return recipe;
    }

    @Before
    public void init() {
        recipe = new Recipe();
        recipe.setId(123L);
    }
}
