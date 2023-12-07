package use_case.view_recipe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewRecipeInputDataTest {

    @Test
    void getTitle_ReturnsCorrectTitle() {
        String expectedTitle = "Test Recipe";
        ViewRecipeInputData inputData = new ViewRecipeInputData(expectedTitle);

        assertEquals(expectedTitle, inputData.getTitle());
    }
}
