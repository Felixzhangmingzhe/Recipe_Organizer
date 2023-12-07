package interface_adapter.Back;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BackViewModelTest {

    private BackViewModel viewModel;
    private PropertyChangeListener listener;

    @BeforeEach
    void setUp() {
        viewModel = new BackViewModel();
        listener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(listener);
    }

    @Test
    void getState() {
        BackState state = viewModel.getState();
        assertNotNull(state, "getState should not return null.");
    }

    @Test
    void setState() {
        BackState newState = new BackState();
        newState.setNumOfCooked(10);
        viewModel.setState(newState);

        BackState retrievedState = viewModel.getState();
        assertSame(newState, retrievedState, "getState should return the state set by setState.");
    }

    @Test
    void firePropertyChanged() {
        viewModel.firePropertyChanged();

        verify(listener, times(1)).propertyChange(any());
    }

    @Test
    void addPropertyChangeListener() {
        viewModel.firePropertyChanged(); // Trigger property change event after adding the listener

        verify(listener, times(1)).propertyChange(any());
    }
}
