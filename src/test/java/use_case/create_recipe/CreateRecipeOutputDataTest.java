package use_case.create_recipe;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CreateRecipeOutputDataTest {

    @Test
    void getId() {
        int expectedId = 1;
        CreateRecipeOutputData outputData = new CreateRecipeOutputData(expectedId, "Test Title", "Content", false, 300.0, LocalDateTime.now());

        assertEquals(expectedId, outputData.getId(), "getId should return the ID set in the constructor.");
    }

    @Test
    void getTitle() {
        String expectedTitle = "Test Title";
        CreateRecipeOutputData outputData = new CreateRecipeOutputData(1, expectedTitle, "Content", false, 300.0, LocalDateTime.now());

        assertEquals(expectedTitle, outputData.getTitle(), "getTitle should return the title set in the constructor.");
    }

    @Test
    void getContent() {
        String expectedContent = "Content";
        CreateRecipeOutputData outputData = new CreateRecipeOutputData(1, "Test Title", expectedContent, false, 300.0, LocalDateTime.now());

        assertEquals(expectedContent, outputData.getContent(), "getContent should return the content set in the constructor.");
    }

    @Test
    void getIsFavorite() {
        boolean expectedIsFavorite = false;
        CreateRecipeOutputData outputData = new CreateRecipeOutputData(1, "Test Title", "Content", expectedIsFavorite, 300.0, LocalDateTime.now());

        assertEquals(expectedIsFavorite, outputData.getisFavorite(), "getisFavorite should return the isFavorite status set in the constructor.");
    }

    @Test
    void getCalories() {
        double expectedCalories = 300.0;
        CreateRecipeOutputData outputData = new CreateRecipeOutputData(1, "Test Title", "Content", false, expectedCalories, LocalDateTime.now());

        assertEquals(expectedCalories, outputData.getCalories(), "getCalories should return the calories set in the constructor.");
    }

    @Test
    void getCreatedAt() {
        LocalDateTime expectedCreatedAt = LocalDateTime.now();
        CreateRecipeOutputData outputData = new CreateRecipeOutputData(1, "Test Title", "Content", false, 300.0, expectedCreatedAt);

        assertEquals(expectedCreatedAt, outputData.getCreatedAt(), "getCreatedAt should return the creation date set in the constructor.");
    }
}
