package use_case.view_favorites;

import entity.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ViewFavoritesInteractorTest {

    @Mock
    private ViewFavoritesDataAccessInterface mockDataAccessInterface;

    @Mock
    private ViewFavoritesOutputBoundary mockPresenter;

    private ViewFavoritesInteractor mockInteractor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockInteractor = new ViewFavoritesInteractor(mockDataAccessInterface, mockPresenter);
    }

    @Test
    void execute_CallsPrepareSuccessViewWithFavorites() {
        List<Recipe> mockFavorites = Arrays.asList(
                new Recipe(1, "Recipe 1", "Content 1", LocalDateTime.now(), true, false, 200),
                new Recipe(2, "Recipe 2", "Content 2", LocalDateTime.now(), true, true, 300)
        );

        when(mockDataAccessInterface.getFavorites()).thenReturn(mockFavorites);

        mockInteractor.execute();

        // Verify that getFavorites is called on the data access object
        verify(mockDataAccessInterface, times(1)).getFavorites();

        // Verify that prepareSuccessView is called on the presenter with the correct data
        verify(mockPresenter, times(1)).prepareSuccessView(any(ViewFavoritesOutputData.class));
    }
}
