package use_case.click_search;

import entity.Recipe;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClickSearchOutputDataTest {

    @Test
    void getSearchedRecipes() {
        // Prepare test data
        Recipe recipe1 = new Recipe(1, "Recipe1", "Content1", LocalDateTime.now(), true, false, 250.0);
        Recipe recipe2 = new Recipe(2, "Recipe2", "Content2", LocalDateTime.now(), false, true, 300.0);
        List<Recipe> expectedRecipes = Arrays.asList(recipe1, recipe2);

        // Create ClickSearchOutputData instance with the test data
        ClickSearchOutputData outputData = new ClickSearchOutputData(expectedRecipes);

        // Retrieve and verify the list of recipes
        List<Recipe> actualRecipes = outputData.getSearchedRecipes();
        assertEquals(expectedRecipes, actualRecipes, "getSearchedRecipes should return the list of recipes set in the constructor.");
    }
}
