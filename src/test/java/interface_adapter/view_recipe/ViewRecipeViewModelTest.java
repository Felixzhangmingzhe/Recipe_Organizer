package interface_adapter.view_recipe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ViewRecipeViewModelTest {

    private ViewRecipeViewModel viewModel;

    @Mock
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        viewModel = new ViewRecipeViewModel();
    }

    @Test
    void testSettersAndGetters() {
        String title = "Test Title";
        viewModel.setTitle(title);
        assertEquals(title, viewModel.getTitle());

        String content = "Test Content";
        viewModel.setContent(content);
        assertEquals(content, viewModel.getContent());

        LocalDateTime creationTime = LocalDateTime.now();
        viewModel.setCreationTime(creationTime);
        assertEquals(creationTime, viewModel.getCreationTime());

        double calories = 250.0;
        viewModel.setCalories(calories);
        assertEquals(calories, viewModel.getCalories(), 0.01);

        boolean isCooked = true;
        viewModel.setIsCooked(isCooked);
        assertEquals(isCooked, viewModel.getIsCooked());

        String errorMessage = "No recipe found";
        viewModel.setNoRecipeFoundMessage(errorMessage);
        assertEquals(errorMessage, viewModel.getNoRecipeFoundMessage());

        boolean isFavorite = true;
        viewModel.setIsFavorite(isFavorite);
        assertEquals(isFavorite, viewModel.getIsFavorite());
    }

    @Test
    void firePropertyChanged_NotifiesListeners() {
        viewModel.addPropertyChangeListener(mockListener);
        viewModel.firePropertyChanged();
        verify(mockListener, times(1)).propertyChange(any());
    }

    @Test
    void addPropertyChangeListener_AddsListener() {
        viewModel.addPropertyChangeListener(mockListener);
        viewModel.firePropertyChanged();
        verify(mockListener, times(1)).propertyChange(any());
    }
}
