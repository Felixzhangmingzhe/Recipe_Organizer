package use_case.view_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ViewSearchInteractorTest {

    @Mock
    private ViewSearchOutputBoundary mockPresenter;

    private ViewSearchInteractor interactor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        interactor = new ViewSearchInteractor(mockPresenter);
    }

    @Test
    public void testExecute() {
        // Call the execute method
        interactor.execute();

        // Verify that prepareSuccessView method is called on the presenter
        verify(mockPresenter, times(1)).prepareSuccessView();
    }
}
