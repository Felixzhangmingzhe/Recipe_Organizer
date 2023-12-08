package use_case.click_search;

import entity.Recipe;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class ClickSearchInteractorTest {

    @Mock
    private ClickSearchDataAccessInterface clickSearchDataAccessInterface;
    @Mock
    private ClickSearchOutputBoundary clickSearchPresenter;

    private ClickSearchInteractor clickSearchInteractor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        interactor = new ClickSearchInteractor(clickSearchDataAccess, clickSearchPresenter);
=======
        clickSearchInteractor = new ClickSearchInteractor(clickSearchDataAccessInterface, clickSearchPresenter);
    }

    @Test
    void clickSearch_RecipesFound() throws IOException, JSONException {
        String title = "Test Recipe";
        Recipe recipe = new Recipe(1, title, "Test Content", LocalDateTime.now(), false, false, 300.0);
        List<Recipe> recipes = Arrays.asList(recipe);
        when(clickSearchDataAccessInterface.getRecipesFromAPI(title)).thenReturn(recipes);

        ClickSearchInputData inputData = new ClickSearchInputData(title);
        clickSearchInteractor.clickSearch(inputData);

        verify(clickSearchDataAccessInterface, times(1)).getRecipesFromAPI(title);
        verify(clickSearchPresenter, times(1)).prepareSuccessView(any(ClickSearchOutputData.class));
    }

    @Test
    void clickSearch_NoRecipesFound() throws IOException, JSONException {
        String title = "Test Recipe";
        when(clickSearchDataAccessInterface.getRecipesFromAPI(title)).thenReturn(Collections.emptyList());

        ClickSearchInputData inputData = new ClickSearchInputData(title);
        clickSearchInteractor.clickSearch(inputData);

        verify(clickSearchDataAccessInterface, times(1)).getRecipesFromAPI(title);
        verify(clickSearchPresenter, times(1)).prepareFailView("No recipes found");
    }

    @Test
    void clickSearch_ErrorOccurs() throws IOException, JSONException {
        String title = "Test Recipe";
        when(clickSearchDataAccessInterface.getRecipesFromAPI(title)).thenThrow(new IOException("Network Error"));

        ClickSearchInputData inputData = new ClickSearchInputData(title);
        clickSearchInteractor.clickSearch(inputData);

        verify(clickSearchDataAccess, times(1)).getRecipesFromAPI(title);

    }
    @Test
    void clickSearch_ErrorOccurs2() throws IOException, JSONException {
        String title = "Test Recipe";
        when(clickSearchDataAccess.getRecipesFromAPI(title)).thenThrow(new JSONException("JSON Error"));

        ClickSearchInputData inputData = new ClickSearchInputData(title);
        interactor.clickSearch(inputData);

        verify(clickSearchDataAccess, times(1)).getRecipesFromAPI(title);

=======
        verify(clickSearchDataAccessInterface, times(1)).getRecipesFromAPI(title);
        verify(clickSearchPresenter, times(1)).prepareFailView("Network Error");
    }
}
