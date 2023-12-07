package use_case.view_warehouse;

import entity.Recipe;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ViewWarehouseOutputDataTest {

    @Test
    void getRecipes_ReturnsCorrectRecipes() {
        // Creating test data
        Recipe recipe1 = new Recipe(1, "Recipe 1", "Content 1", LocalDateTime.now(), true, false, 200);
        Recipe recipe2 = new Recipe(2, "Recipe 2", "Content 2", LocalDateTime.now(), false, true, 300);
        List<Recipe> testRecipes = Arrays.asList(recipe1, recipe2);

        // Creating ViewWarehouseOutputData with the test data
        ViewWarehouseOutputData outputData = new ViewWarehouseOutputData(testRecipes);

        // Asserting that the getRecipes method returns the correct list
        assertEquals(testRecipes, outputData.getRecipes());
    }
}
