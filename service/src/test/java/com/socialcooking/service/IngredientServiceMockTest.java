package com.socialcooking.service;


import com.socialcooking.domain.Delivery;
import com.socialcooking.domain.Ingredient;
import com.socialcooking.repository.DeliveryRepositoryImpl;
import com.socialcooking.repository.IngredientRepositoryImpl;
import com.socialcooking.repository.api.DeliveryRepository;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.repository.api.IngredientRepository;
import com.socialcooking.service.api.GenericService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class IngredientServiceMockTest extends AbstractGenericServiceMockTest<Ingredient>{

    @InjectMocks
    private IngredientServiceImpl ingredientService = new IngredientServiceImpl();

    @Mock
    private IngredientRepository ingredientRepository = new IngredientRepositoryImpl();

    private Ingredient ingredient;

    @Override
    protected GenericService<Ingredient> getService() {
        return ingredientService;
    }

    @Override
    protected GenericRepository<Ingredient> getMockRepository() {
        return ingredientRepository;
    }

    @Override
    protected Ingredient getEntity() {
        return ingredient;
    }

    @Before
    public void init() {
        ingredient = new Ingredient();
        ingredient.setId(123L);
    }
}
