package interface_adapter.view_warehouse;

import entity.Recipe;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ViewWarehouseStateTest {

    @Test
    void setAndGetRecipes() {
        ViewWarehouseState state = new ViewWarehouseState();
        List<Recipe> expectedRecipes = Arrays.asList(
                new Recipe(1, "Recipe 1", "Content 1", LocalDateTime.now(), true, false, 200),
                new Recipe(2, "Recipe 2", "Content 2", LocalDateTime.now(), false, true, 300)
        );

        state.setRecipes(expectedRecipes);
        assertEquals(expectedRecipes, state.getRecipes());
    }

    @Test
    void setAndGetRecipesError() {
        ViewWarehouseState state = new ViewWarehouseState();
        String expectedError = "An error occurred";

        state.setRecipesError(expectedError);
        assertEquals(expectedError, state.getRecipesError());
    }
}
