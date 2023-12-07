package use_case.Back;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class BackInteractorTest {

    @Mock
    private BackDataAccessInterface backDataAccessInterface;
    @Mock
    private BackOutputBoundary presenter;

    private BackInteractor interactor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        interactor = new BackInteractor(presenter, backDataAccessInterface);
    }

    @Test
    void execute() {
        int expectedNumOfCooked = 5;
        when(backDataAccessInterface.getNumOfCooked()).thenReturn(expectedNumOfCooked);

        interactor.execute();

        verify(backDataAccessInterface, times(1)).getNumOfCooked();
        verify(presenter, times(1)).prepareSuccessView(any(BackOutputData.class));
    }
}
