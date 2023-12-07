package interface_adapter.edit_recipe;

import interface_adapter.edit_recipe.EditRecipeState;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EditRecipeStateTest {

    @Test
    void testGetRecipeTitle() {
        EditRecipeState state = new EditRecipeState();
        state.setRecipeTitle("Title");
        assertEquals("Title", state.getRecipeTitle());
    }

    @Test
    void testGetRecipeContent() {
        EditRecipeState state = new EditRecipeState();
        state.setRecipeContent("Content");
        assertEquals("Content", state.getRecipeContent());
    }

    @Test
    void testSetRecipeTitle() {
        EditRecipeState state = new EditRecipeState();
        state.setRecipeTitle("Title");
        assertEquals("Title", state.getRecipeTitle());
    }

    @Test
    void testSetRecipeContent() {
        EditRecipeState state = new EditRecipeState();
        state.setRecipeContent("Content");
        assertEquals("Content", state.getRecipeContent());
    }

    @Test
    void testGetRecipeId() {
        EditRecipeState state = new EditRecipeState();
        state.setRecipeId(1);
        assertEquals(1, state.getRecipeId());
    }

    @Test
    void testSetRecipeId() {
        EditRecipeState state = new EditRecipeState();
        state.setRecipeId(1);
        assertEquals(1, state.getRecipeId());
    }

    @Test
    void testGetRecipeIsFavorite() {
        EditRecipeState state = new EditRecipeState();
        state.setRecipeIsFavorite(true);
        assertTrue(state.getRecipeIsFavorite());
    }

    @Test
    void testSetRecipeIsFavorite() {
        EditRecipeState state = new EditRecipeState();
        state.setRecipeIsFavorite(true);
        assertTrue(state.getRecipeIsFavorite());
    }

    @Test
    void testGetRecipeCalories() {
        EditRecipeState state = new EditRecipeState();
        state.setRecipeCalories(500.0);
        assertEquals(500.0, state.getRecipeCalories(), 0.01); // Use delta for double comparison
    }

    @Test
    void testSetRecipeCalories() {
        EditRecipeState state = new EditRecipeState();
        state.setRecipeCalories(500.0);
        assertEquals(500.0, state.getRecipeCalories(), 0.01); // Use delta for double comparison
    }

    @Test
    void testGetRecipeCooked() {
        EditRecipeState state = new EditRecipeState();
        state.setRecipeCooked(true);
        assertTrue(state.getRecipeCooked());
    }

    @Test
    void testSetRecipeCooked() {
        EditRecipeState state = new EditRecipeState();
        state.setRecipeCooked(true);
        assertTrue(state.getRecipeCooked());
    }

    @Test
    void testGetRecipeCreationTime() {
        LocalDateTime now = LocalDateTime.now();
        EditRecipeState state = new EditRecipeState();
        state.setRecipeCreationTime(now);
        assertEquals(now, state.getRecipeCreationTime());
    }

    @Test
    void testSetRecipeCreationTime() {
        LocalDateTime now = LocalDateTime.now();
        EditRecipeState state = new EditRecipeState();
        state.setRecipeCreationTime(now);
        assertEquals(now, state.getRecipeCreationTime());
    }
}
