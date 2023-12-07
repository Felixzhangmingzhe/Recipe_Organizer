package interface_adapter.jump_to_edit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class JumpToEditViewModelTest {

    private JumpToEditViewModel viewModel;

    @Mock
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        viewModel = new JumpToEditViewModel();
    }

    @Test
    void setStateAndGetState() {
        JumpToEditState state = new JumpToEditState();
        state.setRecipeTitle("Test Title");
        viewModel.setState(state);

        assertEquals("Test Title", viewModel.getState().getRecipeTitle());
    }

    @Test
    void firePropertyChanged() {
        viewModel.addPropertyChangeListener(mockListener);
        viewModel.firePropertyChanged();

        verify(mockListener, times(1)).propertyChange(any(PropertyChangeEvent.class));
    }

    @Test
    void addPropertyChangeListener() {
        viewModel.addPropertyChangeListener(mockListener);
        viewModel.firePropertyChanged();

        // Verify that the listener is called
        verify(mockListener, times(1)).propertyChange(any(PropertyChangeEvent.class));
    }
}
