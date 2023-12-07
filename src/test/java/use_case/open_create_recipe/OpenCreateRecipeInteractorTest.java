package use_case.open_create_recipe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class OpenCreateRecipeInteractorTest {

    @Mock
    private OpenCreateRecipeDataAccessInterface mockDataAccess;

    @Mock
    private OpenCreateRecipeOutputBoundary mockPresenter;

    private OpenCreateRecipeInteractor interactor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        interactor = new OpenCreateRecipeInteractor(mockPresenter, mockDataAccess);
    }

    @Test
    void execute_CallsPrepareSuccessView() {
        interactor.execute();

        // Verify that prepareSuccessView is called on the presenter
        verify(mockPresenter, times(1)).prepareSuccessView();
    }
}
