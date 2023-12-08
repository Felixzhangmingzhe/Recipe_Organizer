package interface_adapter.create_recipe;

import interface_adapter.ViewManagerModel;

import use_case.create_recipe.CreateRecipeOutputData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class CreateRecipePresenterTest {

    @Mock
    private CreateRecipeViewModel createRecipeViewModel;
    @Mock
    private ViewManagerModel viewManagerModel;
    @Mock
    private CreateRecipeState state;

    private CreateRecipePresenter presenter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(createRecipeViewModel.getState()).thenReturn(state);
        presenter = new CreateRecipePresenter(createRecipeViewModel, viewManagerModel);
    }

    @Test
    void prepareSuccessView() {
        LocalDateTime now = LocalDateTime.now();
        CreateRecipeOutputData outputData = new CreateRecipeOutputData(1, "Test Recipe", "Content", true, 300.0, now);

        presenter.prepareSuccessView(outputData);

        verify(state, times(1)).setRecipeName("Test Recipe");
        verify(state, times(1)).setContent("Content");
        verify(state, times(1)).setCreatedAt(now);
        verify(state, times(1)).setCalories(300.0);
        verify(state, times(1)).setIsInFavorites(true);
        verify(createRecipeViewModel, times(1)).setState(state);
        verify(createRecipeViewModel, times(1)).firePropertyChanged();
        verify(viewManagerModel, times(1)).setActiveView(createRecipeViewModel.getViewName());
        verify(viewManagerModel, times(1)).firePropertyChanged();
    }

    @Test
    void prepareFailView() {
        String error = "Title is empty";
        presenter.prepareFailView(error);

        verify(state, times(1)).setRecipeNameError(error);
        verify(createRecipeViewModel, times(2)).firePropertyChanged(); // This is called twice in the method
    }
}
