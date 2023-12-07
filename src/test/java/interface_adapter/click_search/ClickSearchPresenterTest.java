package interface_adapter.click_search;

import entity.Recipe;
import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.click_search.ClickSearchOutputData;

import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

class ClickSearchPresenterTest {

    @Mock
    private ClickSearchViewModel clickSearchViewModel;
    @Mock
    private ViewManagerModel viewManagerModel;
    @Mock
    private ClickSearchState state;

    private ClickSearchPresenter presenter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(clickSearchViewModel.getState()).thenReturn(state);
        presenter = new ClickSearchPresenter(clickSearchViewModel, viewManagerModel);
    }

    @Test
    void prepareSuccessView() {
        List<Recipe> recipes = Collections.singletonList(new Recipe(1, "Test Recipe", "Content", LocalDateTime.now(), true, false, 300.0));
        ClickSearchOutputData outputData = new ClickSearchOutputData(recipes);

        presenter.prepareSuccessView(outputData);

        verify(state, times(1)).setRecipes(recipes);
        verify(clickSearchViewModel, times(1)).setState(state);
        verify(clickSearchViewModel, times(1)).firePropertyChanged();
        verify(viewManagerModel, times(1)).setActiveView(clickSearchViewModel.getViewName());
        verify(viewManagerModel, times(1)).firePropertyChanged();
    }

    @Test
    void prepareFailView() {
        String error = "No recipes found";

        presenter.prepareFailView(error);

        verify(state, times(1)).setRecipesError("Cannot find recipe");
        verify(clickSearchViewModel, times(1)).firePropertyChanged();
        verify(viewManagerModel, times(1)).setActiveView("search");
        verify(viewManagerModel, times(1)).firePropertyChanged();
    }
}
