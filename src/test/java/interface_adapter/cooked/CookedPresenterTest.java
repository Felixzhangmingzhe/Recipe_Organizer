package interface_adapter.cooked;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import interface_adapter.ViewManagerModel;
import use_case.cooked.CookedOutputData;

import static org.mockito.Mockito.*;

class CookedPresenterTest {

    @Mock
    private CookedViewModel cookedViewModel;
    @Mock
    private ViewManagerModel viewManagerModel;
    @Mock
    private CookedState state;

    private CookedPresenter presenter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(cookedViewModel.getState()).thenReturn(state);
        presenter = new CookedPresenter(cookedViewModel, viewManagerModel);
    }

    @Test
    void prepareSuccessView() {
        CookedOutputData outputData = new CookedOutputData(true);

        presenter.prepareSuccessView(outputData);

        verify(state, times(1)).setSetCookedSuccess(true);
        verify(cookedViewModel, times(1)).setState(state);
        verify(cookedViewModel, times(1)).setSetCookedSuccess(true);
        verify(cookedViewModel, times(1)).firePropertyChanged();
        verify(viewManagerModel, times(1)).setActiveView(cookedViewModel.getViewName());
        verify(viewManagerModel, times(1)).firePropertyChanged();
    }

    @Test
    void prepareFailView() {
        CookedOutputData outputData = new CookedOutputData(false);

        presenter.prepareFailView(outputData);

        verify(state, times(1)).setSetCookedSuccess(false);
        verify(cookedViewModel, times(1)).setState(state);
        verify(cookedViewModel, times(1)).setSetCookedSuccess(false);
        verify(cookedViewModel, times(1)).firePropertyChanged();
        verify(viewManagerModel, times(1)).setActiveView(cookedViewModel.getViewName());
        verify(viewManagerModel, times(1)).firePropertyChanged();
    }
}
