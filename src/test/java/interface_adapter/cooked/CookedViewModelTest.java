package interface_adapter.cooked;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.beans.PropertyChangeListener;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CookedViewModelTest {

    private CookedViewModel viewModel;
    private CookedState state;
    private PropertyChangeListener listener;

    @BeforeEach
    void setUp() {
        viewModel = new CookedViewModel();
        when(viewModel.getState()).thenReturn(state);
        listener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(listener);
    }

    @Test
    void getStateAndSetState() {
        CookedState expectedState = new CookedState();
        viewModel.setState(expectedState);

        CookedState actualState = viewModel.getState();
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

    @Test
    void getAndSetSetCookedSuccess() {
         state.setSetCookedSuccess(true);
         assertTrue(state.getSetCookedSuccess(), "getSetCookedSuccess should return true when setSetCookedSuccess(true) is called.");

         state.setSetCookedSuccess(false);
         assertFalse(state.getSetCookedSuccess(), "getSetCookedSuccess should return false when setSetCookedSuccess(false) is called.");
    }
}
