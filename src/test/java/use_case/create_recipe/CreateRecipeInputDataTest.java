package use_case.create_recipe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateRecipeInputDataTest {

    @Test
    void testCreateRecipeInputData() {
        String title = "Spaghetti Bolognese";
        String content = "Cook the spaghetti. Cook the ground beef. Mix them together.";

        CreateRecipeInputData inputData = new CreateRecipeInputData(title, content);
        assertEquals(title, inputData.getTitle());
        assertEquals(content, inputData.getContent());
    }
}
