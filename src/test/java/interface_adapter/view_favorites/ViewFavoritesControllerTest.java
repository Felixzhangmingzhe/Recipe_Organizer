package interface_adapter.view_favorites;

import use_case.view_favorites.ViewFavoritesInputBoundary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class ViewFavoritesControllerTest {

    @Mock
    private ViewFavoritesInputBoundary mockInteractor;

    private ViewFavoritesController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new ViewFavoritesController(mockInteractor);
    }

    @Test
    void execute_CallsInteractorExecute() {
        controller.execute();

        // Verify that execute is called on the interactor
        verify(mockInteractor, times(1)).execute();
    }
}
