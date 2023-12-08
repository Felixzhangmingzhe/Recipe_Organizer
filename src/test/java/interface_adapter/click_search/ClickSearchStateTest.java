package interface_adapter.click_search;

import entity.Recipe;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClickSearchStateTest {

    @Test
    void getAndSetRecipes() {
        ClickSearchState state = new ClickSearchState();
        Recipe recipe = new Recipe(1, "Test Recipe", "Description", LocalDateTime.now(), true, false, 200.0);
        List<Recipe> expectedRecipes = Arrays.asList(recipe);

        state.setRecipes(expectedRecipes);
        List<Recipe> actualRecipes = state.getRecipes();

        assertEquals(expectedRecipes, actualRecipes, "getRecipes should return what was set by setRecipes.");
    }

    @Test
    void getAndSetRecipesError() {
        ClickSearchState state = new ClickSearchState();
        String expectedError = "Error message";

        state.setRecipesError(expectedError);
        String actualError = state.getRecipesError();

        assertEquals(expectedError, actualError, "getRecipesError should return what was set by setRecipesError.");
    }

    @Test
    void getAndSetSearchError() {
        ClickSearchState state = new ClickSearchState();
        String expectedError = "Network Error";

        state.setSearchError(expectedError);
        String actualError = state.getSearchError();

        assertEquals(expectedError, actualError, "getSearchError should return what was set by setSearchError.");
    }

    @Test
    void getAndSetSearchQuery() {
        ClickSearchState state = new ClickSearchState();
        String expectedQuery = "Chicken";

        state.setSearchQuery(expectedQuery);
        String actualQuery = state.getSearchQuery();

        assertEquals(expectedQuery, actualQuery, "getSearchQuery should return what was set by setSearchQuery.");
    }
}
