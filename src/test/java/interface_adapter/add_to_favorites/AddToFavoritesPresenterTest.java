package interface_adapter.add_to_favorites;

import interface_adapter.ViewManagerModel;

import use_case.add_to_favorites.AddToFavoritesOutputData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class AddToFavoritesPresenterTest {

    @Mock
    private AddToFavoritesViewModel viewModel;
    @Mock
    private ViewManagerModel viewManagerModel;
    @Mock
    private AddToFavoritesState state;

    private AddToFavoritesPresenter presenter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(viewModel.getState()).thenReturn(state);
        presenter = new AddToFavoritesPresenter(viewModel, viewManagerModel);
    }

    @Test
    void prepareSuccessView() {
        AddToFavoritesOutputData outputData = new AddToFavoritesOutputData("Added to Favorites", "Removed from Favorites");

        presenter.prepareSuccessView(outputData);

        verify(state, times(1)).setAddToFavoritesMessage("Added to Favorites");
        verify(state, times(1)).setDeleteFromFavoritesMessage("Removed from Favorites");
        verify(viewModel, times(1)).setState(state);
        verify(viewModel, times(1)).firePropertyChanged();
        verify(viewManagerModel, times(1)).setActiveView(viewModel.getViewName());
        verify(viewManagerModel, times(1)).firePropertyChanged();
    }
}
