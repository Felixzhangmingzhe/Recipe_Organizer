package use_case.view_warehouse;

import entity.Recipe;

import interface_adapter.view_warehouse.ViewWarehousePresenter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ViewWarehouseInteractorTest {

    @Mock
    private ViewWarehouseDataAccessInterface mockDataAccessInterface;

    @Mock
    private ViewWarehousePresenter mockPresenter;

    private ViewWarehouseInteractor mockInteractor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockInteractor = new ViewWarehouseInteractor(mockDataAccessInterface, mockPresenter);
    }

    @Test
    void execute_SuccessfulRetrieval() {
        List<Recipe> testRecipes = Arrays.asList(
                new Recipe(1, "Test Recipe 1", "Content 1", LocalDateTime.now(), true, false, 200),
                new Recipe(2, "Test Recipe 2", "Content 2", LocalDateTime.now(), false, true, 300)
        );
        when(mockDataAccessInterface.getAllRecipe()).thenReturn(testRecipes);

        mockInteractor.execute();

        // Verify that the data access interface method is called
        verify(mockDataAccessInterface, times(1)).getAllRecipe();

        // Verify that the presenter's method is called with the correct data
        verify(mockPresenter, times(1)).prepareSuccessView(any(ViewWarehouseOutputData.class));
    }
}
