package use_case.edit_recipe;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EditRecipeOutputDataTest {

    @Test
    void testGetRecipeTitle() {
        EditRecipeOutputData outputData = new EditRecipeOutputData("Title", "Content", 1, true, 500.0, false, LocalDateTime.now());
        assertEquals("Title", outputData.getRecipeTitle());
    }

    @Test
    void testGetRecipeContent() {
        EditRecipeOutputData outputData = new EditRecipeOutputData("Title", "Content", 1, true, 500.0, false, LocalDateTime.now());
        assertEquals("Content", outputData.getRecipeContent());
    }

    @Test
    void testGetRecipeId() {
        EditRecipeOutputData outputData = new EditRecipeOutputData("Title", "Content", 1, true, 500.0, false, LocalDateTime.now());
        assertEquals(1, outputData.getRecipeId());
    }

    @Test
    void testGetRecipeIsFavorite() {
        EditRecipeOutputData outputData = new EditRecipeOutputData("Title", "Content", 1, true, 500.0, false, LocalDateTime.now());
        assertTrue(outputData.getRecipeIsFavorite());
    }

    @Test
    void testGetRecipeCalories() {
        EditRecipeOutputData outputData = new EditRecipeOutputData("Title", "Content", 1, true, 500.0, false, LocalDateTime.now());
        assertEquals(500.0, outputData.getRecipeCalories(), 0.01); // Use delta for double comparison
    }

    @Test
    void testGetRecipeCooked() {
        EditRecipeOutputData outputData = new EditRecipeOutputData("Title", "Content", 1, true, 500.0, false, LocalDateTime.now());
        assertFalse(outputData.getRecipeCooked());
    }

    @Test
    void testGetRecipeCreationTime() {
        LocalDateTime now = LocalDateTime.now();
        EditRecipeOutputData outputData = new EditRecipeOutputData("Title", "Content", 1, true, 500.0, false, now);
        assertEquals(now, outputData.getRecipeCreationTime());
    }
}
