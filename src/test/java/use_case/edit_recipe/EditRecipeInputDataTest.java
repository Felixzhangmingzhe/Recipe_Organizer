package use_case.edit_recipe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditRecipeInputDataTest {

    @Test
    void testGetTitle() {
        EditRecipeInputData inputData = new EditRecipeInputData("Original Title", "New Title", "Recipe Content");
        assertEquals("New Title", inputData.getTitle());
    }

    @Test
    void testGetContent() {
        EditRecipeInputData inputData = new EditRecipeInputData("Original Title", "New Title", "Recipe Content");
        assertEquals("Recipe Content", inputData.getContent());
    }

    @Test
    void testGetOriginalRecipeTitle() {
        EditRecipeInputData inputData = new EditRecipeInputData("Original Title", "New Title", "Recipe Content");
        assertEquals("Original Title", inputData.getOriginalRecipeTiltle());
    }
}
