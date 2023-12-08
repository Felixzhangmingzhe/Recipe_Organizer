package use_case.add_to_favorites;

import entity.Recipe;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class AddToFavoritesInteractorTest {

    @Mock
    private AddToFavoritesDataAccessInterface userDataAccess;

    @Mock
    private AddToFavoritesOutputBoundary presenter;

    private AddToFavoritesInteractor interactor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        interactor = new AddToFavoritesInteractor(userDataAccess, presenter);
    }

    @Test
    void executeAddsRecipeToFavorites() throws JSONException {
        String title = "Test Recipe";
        Recipe recipe = new Recipe(1, title, "Content", LocalDateTime.now(), false, false, 300.0);
        when(userDataAccess.getRecipeByTitle(title)).thenReturn(recipe);

        AddToFavoritesInputData inputData = new AddToFavoritesInputData(title);
        interactor.execute(inputData);

        verify(userDataAccess).updateRecipe(1, title, "Content", recipe.getDate(), true, false, 300.0);
        verify(presenter).prepareSuccessView(any(AddToFavoritesOutputData.class));
    }

    @Test
    void executeRemovesRecipeFromFavorites() throws JSONException {
        String title = "Test Recipe";
        Recipe recipe = new Recipe(1, title, "Content", LocalDateTime.now(), true, false, 300.0);
        when(userDataAccess.getRecipeByTitle(title)).thenReturn(recipe);

        AddToFavoritesInputData inputData = new AddToFavoritesInputData(title);
        interactor.execute(inputData);

        verify(userDataAccess).updateRecipe(1, title, "Content", recipe.getDate(), false, false, 300.0);
        verify(presenter).prepareSuccessView(any(AddToFavoritesOutputData.class));
    }
}
