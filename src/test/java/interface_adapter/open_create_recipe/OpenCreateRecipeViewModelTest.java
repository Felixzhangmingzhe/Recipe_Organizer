package interface_adapter.open_create_recipe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.mockito.Mockito.*;

class OpenCreateRecipeViewModelTest {

    private OpenCreateRecipeViewModel viewModel;

    @Mock
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        viewModel = new OpenCreateRecipeViewModel();
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
