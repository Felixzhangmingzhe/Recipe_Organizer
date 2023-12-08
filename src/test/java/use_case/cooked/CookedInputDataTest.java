package use_case.cooked;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CookedInputDataTest {

    @Test
    void testCookedInputData() {
        String recipeTitle = "Spaghetti Bolognese";

        CookedInputData inputData = new CookedInputData(recipeTitle);

        assertEquals(recipeTitle, inputData.getRecipeTitle());
    }
}
