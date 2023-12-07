package use_case.view_favorites;

import entity.Recipe;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ViewFavoritesOutputDataTest {

    @Test
    void getRecipes_ReturnsCorrectRecipes() {
        // Create test recipes
        Recipe recipe1 = new Recipe(1, "Recipe 1", "Content 1", LocalDateTime.now(), true, false, 200);
        Recipe recipe2 = new Recipe(2, "Recipe 2", "Content 2", LocalDateTime.now(), true, true, 300);
        List<Recipe> testRecipes = Arrays.asList(recipe1, recipe2);

        // Create ViewFavoritesOutputData with test recipes
        ViewFavoritesOutputData outputData = new ViewFavoritesOutputData(testRecipes);

        // Verify that getRecipes returns the correct list of recipes
        assertEquals(testRecipes, outputData.getRecipes());
    }
}
