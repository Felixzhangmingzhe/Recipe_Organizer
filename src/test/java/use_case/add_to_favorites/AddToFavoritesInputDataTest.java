package use_case.add_to_favorites;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddToFavoritesInputDataTest {

    @Test
    void getTitle() {
        String expectedTitle = "Example Recipe Title";
        AddToFavoritesInputData inputData = new AddToFavoritesInputData(expectedTitle);

        String actualTitle = inputData.getTitle();

        assertEquals(expectedTitle, actualTitle, "The getTitle method should return the title set in the constructor.");
    }
}
