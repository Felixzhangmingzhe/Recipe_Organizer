package use_case.view_recipe;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ViewRecipeOutputDataTest {

    @Test
    void getTitle_ReturnsCorrectTitle() {
        String expectedTitle = "Test Title";
        ViewRecipeOutputData data = new ViewRecipeOutputData(expectedTitle, "Content", LocalDateTime.now(), 200, true, false);
        assertEquals(expectedTitle, data.getTitle());
    }

    @Test
    void getContent_ReturnsCorrectContent() {
        String expectedContent = "Test Content";
        ViewRecipeOutputData data = new ViewRecipeOutputData("Title", expectedContent, LocalDateTime.now(), 200, true, false);
        assertEquals(expectedContent, data.getContent());
    }

    @Test
    void getCreationTime_ReturnsCorrectCreationTime() {
        LocalDateTime expectedTime = LocalDateTime.now();
        ViewRecipeOutputData data = new ViewRecipeOutputData("Title", "Content", expectedTime, 200, true, false);
        assertEquals(expectedTime, data.getCreationTime());
    }

    @Test
    void getCalories_ReturnsCorrectCalories() {
        double expectedCalories = 200.0;
        ViewRecipeOutputData data = new ViewRecipeOutputData("Title", "Content", LocalDateTime.now(), expectedCalories, true, false);
        assertEquals(expectedCalories, data.getCalories(), 0.001);
    }

    @Test
    void getIsFavorite_ReturnsCorrectValue() {
        boolean expectedFavorite = true;
        ViewRecipeOutputData data = new ViewRecipeOutputData("Title", "Content", LocalDateTime.now(), 200, expectedFavorite, false);
        assertEquals(expectedFavorite, data.getIsFavorite());
    }

    @Test
    void getIsCooked_ReturnsCorrectValue() {
        boolean expectedCooked = false;
        ViewRecipeOutputData data = new ViewRecipeOutputData("Title", "Content", LocalDateTime.now(), 200, true, expectedCooked);
        assertEquals(expectedCooked, data.getIsCooked());
    }
}
