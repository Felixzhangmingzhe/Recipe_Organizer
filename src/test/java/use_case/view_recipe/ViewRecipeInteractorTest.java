package use_case.view_recipe;

import entity.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class ViewRecipeInteractorTest {

    @Mock
    private ViewRecipeDataAccessInterface mockDataAccessInterface;

    @Mock
    private ViewRecipeOutputBoundary mockOutputBoundary;

    private ViewRecipeInteractor mockInteractor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockInteractor = new ViewRecipeInteractor(mockDataAccessInterface, mockOutputBoundary);
    }

    @Test
    void viewRecipe_WhenRecipeIsFound() {
        String testTitle = "Test Recipe";
        Recipe foundRecipe = new Recipe(1, testTitle, "Content", LocalDateTime.now(), true, false, 200);
        when(mockDataAccessInterface.getRecipeByTitle(testTitle)).thenReturn(foundRecipe);

        mockInteractor.viewRecipe(new ViewRecipeInputData(testTitle));

        verify(mockOutputBoundary, times(1)).prepareSuccessView(any(ViewRecipeOutputData.class));
        verify(mockOutputBoundary, never()).prepareFailView(anyString());
    }

    @Test
    void viewRecipe_WhenRecipeIsNotFound() {
        String testTitle = "Unknown Recipe";
        when(mockDataAccessInterface.getRecipeByTitle(testTitle)).thenReturn(null);

        mockInteractor.viewRecipe(new ViewRecipeInputData(testTitle));

        verify(mockOutputBoundary, never()).prepareSuccessView(any(ViewRecipeOutputData.class));
        verify(mockOutputBoundary, times(1)).prepareFailView("Recipe not found.");
    }
}
