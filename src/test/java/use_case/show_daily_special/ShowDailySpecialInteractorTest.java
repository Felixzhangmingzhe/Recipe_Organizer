package use_case.show_daily_special;

import entity.Recipe;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

public class ShowDailySpecialInteractorTest {

    @Mock
    private ShowDailySpecialDataAccessInterface mockDataAccessInterface;

    @Mock
    private ShowDailySpecialOutputBoundary mockPresenter;

    private ShowDailySpecialInteractor interactor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        interactor = new ShowDailySpecialInteractor(mockPresenter, mockDataAccessInterface);
    }

    @Test
    public void testExecute() throws IOException, JSONException {
        // Mock data for testing
        Recipe mockRecipe = new Recipe(1, "Test Recipe", "Test Content", LocalDateTime.now(), true, false, 250.0);
        when(mockDataAccessInterface.getDailySpecial()).thenReturn(mockRecipe);

        // Call the execute method
        interactor.execute();

        // Verify that getDailySpecial method is called on the data access interface
        verify(mockDataAccessInterface, times(1)).getDailySpecial();

        // Verify that prepareSuccessView method is called on the presenter with the correct output data
        ShowDailySpecialOutputData expectedOutputData = new ShowDailySpecialOutputData(mockRecipe);
        verify(mockPresenter, times(1)).prepareSuccessView(any(ShowDailySpecialOutputData.class));
    }
}
