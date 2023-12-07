package use_case.jump_to_edit;

import entity.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class JumpToEditInteractorTest {

    @Mock
    private JumpToEditDataAccessInterface mockDataAccess;

    @Mock
    private JumpToEditOutputBoundary mockPresenter;

    private JumpToEditInteractor interactor;
    private Recipe testRecipe;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        interactor = new JumpToEditInteractor(mockDataAccess, mockPresenter);

        // Create a test recipe
        testRecipe = new Recipe(1, "Test Recipe", "Test Content", LocalDateTime.now(), true, false, 250.0);

        // Configure mockDataAccess to return the test recipe when getRecipeByTitle is called
        when(mockDataAccess.getRecipeByTitle("Test Recipe")).thenReturn(testRecipe);
    }

    @Test
    void execute_ShouldCallDataAccessAndPresenter() {
        JumpToEditInputData inputData = new JumpToEditInputData("Test Recipe");

        interactor.execute(inputData);

        // Verify that getRecipeByTitle is called with the correct title
        verify(mockDataAccess).getRecipeByTitle("Test Recipe");

        // Verify that the presenter's prepareSuccessView is called with the correct output data
        verify(mockPresenter).prepareSuccessView(any(JumpToEditOutputData.class));
    }
}
