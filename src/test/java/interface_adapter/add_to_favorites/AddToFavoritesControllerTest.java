package interface_adapter.add_to_favorites;

import use_case.add_to_favorites.AddToFavoritesInputBoundary;
import use_case.add_to_favorites.AddToFavoritesInputData;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class AddToFavoritesControllerTest {

    @Mock
    private AddToFavoritesInputBoundary interactor;

    private AddToFavoritesController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new AddToFavoritesController(interactor);
    }

    @Test
    void execute() throws JSONException {
        String recipeId = "testRecipeId";
        controller.execute(recipeId);

        verify(interactor, times(1)).execute(any(AddToFavoritesInputData.class));
    }
}
