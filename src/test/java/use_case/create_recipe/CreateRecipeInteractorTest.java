package use_case.create_recipe;

import entity.Recipe;
import entity.RecipeFactory;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class CreateRecipeInteractorTest {

    @Mock
    private CreateRecipeOutputBoundary createRecipePresenter;
    @Mock
    private CreateRecipeUserDataAccessInterface createRecipeUserDataAccessInterface;
    @Mock
    private RecipeFactory recipeFactory;

    private CreateRecipeInteractor interactor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        interactor = new CreateRecipeInteractor(createRecipePresenter, createRecipeUserDataAccessInterface, recipeFactory);
    }

    @Test
    void execute_withEmptyTitle() throws JSONException {
        CreateRecipeInputData inputData = new CreateRecipeInputData("", "Content");
        interactor.execute(inputData);

        verify(createRecipePresenter, times(1)).prepareFailView("Title is empty");
    }

    @Test
    void execute_withEmptyContent() throws JSONException {
        CreateRecipeInputData inputData = new CreateRecipeInputData("Title", "");
        interactor.execute(inputData);

        verify(createRecipePresenter, times(1)).prepareFailView("Content is empty");
    }

    @Test
    void execute_withExistingRecipe() throws JSONException {
        when(createRecipeUserDataAccessInterface.existsByName("Existing Title")).thenReturn(true);
        CreateRecipeInputData inputData = new CreateRecipeInputData("Existing Title", "Content");
        interactor.execute(inputData);

        verify(createRecipePresenter, times(1)).prepareFailView("Recipe already exists");
    }

    @Test
    void execute_successfulCreation() throws JSONException {
        when(createRecipeUserDataAccessInterface.existsByName("New Title")).thenReturn(false);
        when(recipeFactory.create(anyInt(), anyString(), anyString(), any(LocalDateTime.class), anyBoolean(), anyDouble(), anyBoolean()))
                .thenReturn(new Recipe(1, "New Title", "Content", LocalDateTime.now(), false, false, 300.0));
        CreateRecipeInputData inputData = new CreateRecipeInputData("New Title", "Content");
        interactor.execute(inputData);

        verify(createRecipeUserDataAccessInterface, times(1)).save(any(Recipe.class));
        verify(createRecipePresenter, times(1)).prepareSuccessView(any(CreateRecipeOutputData.class));
    }
}
