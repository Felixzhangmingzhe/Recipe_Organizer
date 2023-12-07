package interface_adapter.add_to_favorites;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddToFavoritesStateTest {

    @Test
    void getAddToFavoritesMessage() {
        AddToFavoritesState state = new AddToFavoritesState();
        String expectedMessage = "Added to Favorites";
        state.setAddToFavoritesMessage(expectedMessage);

        assertEquals(expectedMessage, state.getAddToFavoritesMessage(), "The getAddToFavoritesMessage method should return the correct message.");
    }

    @Test
    void setAddToFavoritesMessage() {
        AddToFavoritesState state = new AddToFavoritesState();
        String expectedMessage = "Added to Favorites";
        state.setAddToFavoritesMessage(expectedMessage);

        assertEquals(expectedMessage, state.getAddToFavoritesMessage(), "After setting AddToFavoritesMessage, the getter should return the same value.");
    }

    @Test
    void getDeleteFromFavoritesMessage() {
        AddToFavoritesState state = new AddToFavoritesState();
        String expectedMessage = "Deleted from Favorites";
        state.setDeleteFromFavoritesMessage(expectedMessage);

        assertEquals(expectedMessage, state.getDeleteFromFavoritesMessage(), "The getDeleteFromFavoritesMessage method should return the correct message.");
    }

    @Test
    void setDeleteFromFavoritesMessage() {
        AddToFavoritesState state = new AddToFavoritesState();
        String expectedMessage = "Deleted from Favorites";
        state.setDeleteFromFavoritesMessage(expectedMessage);

        assertEquals(expectedMessage, state.getDeleteFromFavoritesMessage(), "After setting DeleteFromFavoritesMessage, the getter should return the same value.");
    }
}
