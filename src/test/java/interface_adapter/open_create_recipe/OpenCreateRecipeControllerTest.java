package interface_adapter.open_create_recipe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.open_create_recipe.OpenCreateRecipeInputBoundary;

import static org.mockito.Mockito.*;

class OpenCreateRecipeControllerTest {

    @Mock
    private OpenCreateRecipeInputBoundary mockInteractor;

    private OpenCreateRecipeController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new OpenCreateRecipeController(mockInteractor);
    }

    @Test
    void execute_CallsInteractorExecute() {
        controller.execute();

        // Verify that execute is called on the interactor
        verify(mockInteractor, times(1)).execute();
    }
}
