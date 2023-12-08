package interface_adapter.create_recipe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CreateRecipeStateTest {
    private CreateRecipeState createRecipeState;

    @BeforeEach
    void setUp() {
        createRecipeState = new CreateRecipeState();
    }

    @Test
    void testGetAndSetRecipeName() {
        createRecipeState.setRecipeName("Test Recipe");
        assertEquals("Test Recipe", createRecipeState.getRecipeName());
    }

    @Test
    void testGetAndSetRecipeNameError() {
        createRecipeState.setRecipeNameError("Name error");
        assertEquals("Name error", createRecipeState.getRecipeNameError());
    }

    @Test
    void testGetAndSetContent() {
        createRecipeState.setContent("Recipe content");
        assertEquals("Recipe content", createRecipeState.getContent());
    }

    @Test
    void testGetAndSetContentError() {
        createRecipeState.setContentError("Content error");
        assertEquals("Content error", createRecipeState.getContentError());
    }

    @Test
    void testGetAndSetCreatedAt() {
        LocalDateTime now = LocalDateTime.now();
        createRecipeState.setCreatedAt(now);
        assertEquals(now, createRecipeState.getCreatedAt());
    }

    @Test
    void testGetAndSetCreatedAtError() {
        createRecipeState.setCreatedAtError("Created at error");
        assertEquals("Created at error", createRecipeState.getCreatedAtError());
    }

    @Test
    void testGetAndSetCalories() {
        createRecipeState.setCalories(500.0);
        assertEquals(500.0, createRecipeState.getCalories(), 0.01); // Use delta for double comparison
    }

    @Test
    void testGetAndSetCaloriesError() {
        createRecipeState.setCaloriesError("Calories error");
        assertEquals("Calories error", createRecipeState.getCaloriesError());
    }

    @Test
    void testGetAndSetConflictError() {
        createRecipeState.setConflictError("Conflict error");
        assertEquals("Conflict error", createRecipeState.getConflictError());
    }

    @Test
    void testGetAndSetIsInFavorites() {
        createRecipeState.setIsInFavorites(true);
        assertTrue(createRecipeState.getIsInFavorites());
    }

    @Test
    void testGetAndSetIsInFavoritesError() {
        createRecipeState.setIsInFavoritesError("Is in favorites error");
        assertEquals("Is in favorites error", createRecipeState.getIsInFavoritesError());
    }
}
