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
    private BackOutputBoundary backPresenter;

    private BackInteractor backInteractor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        backInteractor = new BackInteractor(backPresenter, backDataAccessInterface);
    }

    @Test
    void execute() {
        int expectedNumOfCooked = 5;
        when(backDataAccessInterface.getNumOfCooked()).thenReturn(expectedNumOfCooked);

        backInteractor.execute();

        verify(backDataAccessInterface, times(1)).getNumOfCooked();
        verify(backPresenter, times(1)).prepareSuccessView(any(BackOutputData.class));
    }
}
