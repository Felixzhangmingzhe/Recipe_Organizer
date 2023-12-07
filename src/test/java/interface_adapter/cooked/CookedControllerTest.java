package interface_adapter.cooked;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.cooked.CookedInputBoundary;
import use_case.cooked.CookedInputData;

import static org.mockito.Mockito.*;

class CookedControllerTest {

    @Mock
    private CookedInputBoundary cookedInteractor;

    private CookedController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new CookedController(cookedInteractor);
    }

    @Test
    void execute() throws Exception {
        String recipeTitle = "Test Recipe";
        controller.execute(recipeTitle);

        verify(cookedInteractor, times(1)).execute(any(CookedInputData.class));
    }
}
