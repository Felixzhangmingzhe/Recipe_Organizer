package interface_adapter.Back;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.Back.BackInputBoundary;

import static org.mockito.Mockito.*;

class BackControllerTest {

    @Mock
    private BackInputBoundary backUseCaseInteractor;

    private BackController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new BackController(backUseCaseInteractor);
    }

    @Test
    void execute() {
        controller.execute();

        verify(backUseCaseInteractor, times(1)).execute();
    }
}
