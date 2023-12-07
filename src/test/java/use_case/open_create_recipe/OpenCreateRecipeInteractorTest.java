package use_case.open_create_recipe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class OpenCreateRecipeInteractorTest {

    @Mock
    private OpenCreateRecipeDataAccessInterface mockDataAccessInterface;

    @Mock
    private OpenCreateRecipeOutputBoundary mockPresenter;

    private OpenCreateRecipeInteractor mockInteractor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockInteractor = new OpenCreateRecipeInteractor(mockPresenter, mockDataAccessInterface);
    }

    @Test
    void execute_CallsPrepareSuccessView() {
        mockInteractor.execute();

        // Verify that prepareSuccessView is called on the presenter
        verify(mockPresenter, times(1)).prepareSuccessView();
    }
}
