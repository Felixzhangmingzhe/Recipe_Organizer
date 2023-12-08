package interface_adapter.click_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeListener;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ClickSearchViewModelTest {

    private ClickSearchViewModel viewModel;
    private PropertyChangeListener listener;

    @BeforeEach
    void setUp() {
        viewModel = new ClickSearchViewModel();
        listener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(listener);
    }

    @Test
    void setStateAndGetState() {
        ClickSearchState expectedState = new ClickSearchState();
        viewModel.setState(expectedState);

        ClickSearchState actualState = viewModel.getState();
        assertSame(expectedState, actualState, "getState should return the state set by setState.");
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
