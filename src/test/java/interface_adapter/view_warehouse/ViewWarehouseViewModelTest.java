package interface_adapter.view_warehouse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ViewWarehouseViewModelTest {

    private ViewWarehouseViewModel viewModel;

    @Mock
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        viewModel = new ViewWarehouseViewModel();
    }

    @Test
    void setStateAndGetState() {
        ViewWarehouseState testState = new ViewWarehouseState();
        testState.setRecipesError("Test Error");

        viewModel.setState(testState);
        assertEquals(testState, viewModel.getState());
    }

    @Test
    void firePropertyChanged_NotifiesListeners() {
        viewModel.addPropertyChangeListener(mockListener);
        viewModel.firePropertyChanged();

        verify(mockListener, times(1)).propertyChange(any(PropertyChangeEvent.class));
    }

    @Test
    void addPropertyChangeListener_AddsListener() {
        viewModel.addPropertyChangeListener(mockListener);
        viewModel.firePropertyChanged();

        verify(mockListener, times(1)).propertyChange(any(PropertyChangeEvent.class));
    }
}
