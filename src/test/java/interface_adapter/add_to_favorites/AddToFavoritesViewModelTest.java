package interface_adapter.add_to_favorites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AddToFavoritesViewModelTest {

    private AddToFavoritesViewModel viewModel;

    @BeforeEach
    void setUp() {
        viewModel = new AddToFavoritesViewModel();
    }

    @Test
    void getState() {
        assertNotNull(viewModel.getState(), "getState should not return null.");
    }

    @Test
    void setState() {
        AddToFavoritesState newState = new AddToFavoritesState();
        newState.setAddToFavoritesMessage("New Message");
        viewModel.setState(newState);

        assertSame(newState, viewModel.getState(), "getState should return the state set by setState.");
    }

    @Test
    void firePropertyChanged() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(listener);
        viewModel.firePropertyChanged();

        verify(listener, times(1)).propertyChange(any());
    }

    @Test
    void addPropertyChangeListener() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(listener);

        viewModel.firePropertyChanged(); // Trigger property change event

        verify(listener, times(1)).propertyChange(any());
    }
}
