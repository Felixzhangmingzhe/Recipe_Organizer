package use_case.jump_to_edit;

import entity.Recipe;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class JumpToEditInteractorTest {

    @Mock
    private JumpToEditDataAccessInterface mockDataAccessInterface;

    @Mock
    private JumpToEditOutputBoundary mockPresenter;

    private JumpToEditInteractor mockInteractor;
    private Recipe testRecipe;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockInteractor = new JumpToEditInteractor(mockDataAccessInterface, mockPresenter);

        // Create a test recipe
        testRecipe = new Recipe(1, "Test Recipe", "Test Content", LocalDateTime.now(), true, false, 250.0);

        // Configure mockDataAccess to return the test recipe when getRecipeByTitle is called
        when(mockDataAccessInterface.getRecipeByTitle("Test Recipe")).thenReturn(testRecipe);
    }

    @Test
    void execute_ShouldCallDataAccessAndPresenter() {
        JumpToEditInputData inputData = new JumpToEditInputData("Test Recipe");

        mockInteractor.execute(inputData);

        // Verify that getRecipeByTitle is called with the correct title
        verify(mockDataAccessInterface).getRecipeByTitle("Test Recipe");

        // Verify that the presenter's prepareSuccessView is called with the correct output data
        verify(mockPresenter).prepareSuccessView(any(JumpToEditOutputData.class));
    }
}
