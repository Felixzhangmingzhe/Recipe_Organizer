package interface_adapter.create_recipe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.create_recipe.CreateRecipeInputBoundary;
import use_case.create_recipe.CreateRecipeInputData;

import static org.mockito.Mockito.*;

class CreateRecipeControllerTest {

    @Mock
    private CreateRecipeInputBoundary createRecipeUseCaseInteractor;

    private CreateRecipeController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new CreateRecipeController(createRecipeUseCaseInteractor);
    }

    @Test
    void execute() throws Exception {
        String title = "Test Recipe";
        String content = "Test Content";
        controller.execute(title, content);

        verify(createRecipeUseCaseInteractor, times(1)).execute(any(CreateRecipeInputData.class));
    }
}
