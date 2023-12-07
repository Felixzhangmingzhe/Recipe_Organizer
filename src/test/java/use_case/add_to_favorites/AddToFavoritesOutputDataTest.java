package use_case.add_to_favorites;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddToFavoritesOutputDataTest {

    @Test
    void getAddToFavoritesMessage() {
        String expectedAddMessage = "Recipe added to favorites";
        String expectedDeleteMessage = ""; // Assuming empty since we're testing add message
        AddToFavoritesOutputData outputData = new AddToFavoritesOutputData(expectedAddMessage, expectedDeleteMessage);

        String actualAddMessage = outputData.getAddToFavoritesMessage();

        assertEquals(expectedAddMessage, actualAddMessage, "The getAddToFavoritesMessage method should return the message set in the constructor.");
    }

    @Test
    void getDeleteFromFavoritesMessage() {
        String expectedAddMessage = ""; // Assuming empty since we're testing delete message
        String expectedDeleteMessage = "Recipe removed from favorites";
        AddToFavoritesOutputData outputData = new AddToFavoritesOutputData(expectedAddMessage, expectedDeleteMessage);

        String actualDeleteMessage = outputData.getDeleteFromFavoritesMessage();

        assertEquals(expectedDeleteMessage, actualDeleteMessage, "The getDeleteFromFavoritesMessage method should return the message set in the constructor.");
    }
}
