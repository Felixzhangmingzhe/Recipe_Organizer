package interface_adapter.view_favorites;

import entity.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ViewFavoritesViewModelTest {

    private ViewFavoritesViewModel viewModel;

    @Mock
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        viewModel = new ViewFavoritesViewModel();
    }

    @Test
    void setAndGetRecipes() {
        List<Recipe> recipes = Arrays.asList(
                new Recipe(1, "Recipe 1", "Content 1", LocalDateTime.now(), true, false, 200),
                new Recipe(2, "Recipe 2", "Content 2", LocalDateTime.now(), true, true, 300)
        );
        viewModel.setRecipes(recipes);
        assertEquals(recipes, viewModel.getRecipes());
    }

    @Test
    void firePropertyChanged_NotifiesListeners() {
        viewModel.addPropertyChangeListener(mockListener);
        viewModel.firePropertyChanged();

        // Verify that propertyChange is called on the listener
        verify(mockListener, times(1)).propertyChange(any(PropertyChangeEvent.class));
    }

    @Test
    void addPropertyChangeListener_AddsListener() {
        viewModel.addPropertyChangeListener(mockListener);
        viewModel.firePropertyChanged();

        // Verify that the listener is called
        verify(mockListener, times(1)).propertyChange(any(PropertyChangeEvent.class));
    }
}
