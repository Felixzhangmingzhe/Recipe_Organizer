package use_case.cooked;

import entity.Recipe;
import entity.RecipeFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class CookedInteractorTest {

    @Mock
    private CookedOutputBoundary cookedPresenter;
    @Mock
    private CookedDataAccessInterface cookedDataAccessInterface;

    private CookedInteractor interactor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        interactor = new CookedInteractor(cookedPresenter, cookedDataAccessInterface);
    }

    @Test
    void execute_RecipeAlreadyCooked() throws Exception {
        Recipe recipe = new Recipe(1, "Test Recipe", "Test Content", LocalDateTime.now(), false, true, 300.0);
        when(cookedDataAccessInterface.getRecipeByRecipeTitle("Test Recipe")).thenReturn(recipe);

        CookedInputData inputData = new CookedInputData("Test Recipe");
        interactor.execute(inputData);

        verify(cookedPresenter, times(1)).prepareFailView(any(CookedOutputData.class));
    }

    @Test
    void execute_RecipeNotCooked() throws Exception {
        Recipe recipe = new Recipe(1, "Test Recipe", "Test Content", LocalDateTime.now(), false, false, 300.0);
        when(cookedDataAccessInterface.getRecipeByRecipeTitle("Test Recipe")).thenReturn(recipe);

        CookedInputData inputData = new CookedInputData("Test Recipe");
        interactor.execute(inputData);

        verify(cookedDataAccessInterface, times(1)).updateCookedRecipe(eq(1), anyString(), anyString(), any(LocalDateTime.class), anyBoolean(), eq(true), anyDouble());
        verify(cookedPresenter, times(1)).prepareSuccessView(any(CookedOutputData.class));
    }
}
