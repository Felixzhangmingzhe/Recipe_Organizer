package interface_adapter.Back;

import interface_adapter.ViewManagerModel;

import use_case.Back.BackOutputData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class BackPresenterTest {

    @Mock
    private ViewManagerModel viewManagerModel;
    @Mock
    private BackViewModel viewModel;
    @Mock
    private BackState state;

    private BackPresenter presenter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(viewModel.getState()).thenReturn(state);
        presenter = new BackPresenter(viewManagerModel, viewModel);
    }

    @Test
    void prepareSuccessView() {
        int numOfCooked = 5;
        BackOutputData backOutputData = new BackOutputData(numOfCooked);

        presenter.prepareSuccessView(backOutputData);

        verify(state, times(1)).setNumOfCooked(numOfCooked);
        verify(viewModel, times(1)).setState(state);
        verify(viewModel, times(1)).firePropertyChanged();
        verify(viewManagerModel, times(1)).setActiveView(viewModel.getViewName());
        verify(viewManagerModel, times(1)).firePropertyChanged();
    }
}
