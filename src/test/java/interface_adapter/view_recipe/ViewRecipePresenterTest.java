package interface_adapter.view_recipe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import interface_adapter.ViewManagerModel;
import use_case.view_recipe.ViewRecipeOutputData;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class ViewRecipePresenterTest {

    @Mock
    private ViewRecipeViewModel mockViewModel;

    @Mock
    private ViewManagerModel mockViewManagerModel;

    private ViewRecipePresenter presenter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        presenter = new ViewRecipePresenter(mockViewModel, mockViewManagerModel);
    }

    @Test
    void prepareSuccessView_UpdatesViewModelAndTriggersPropertyChange() {
        ViewRecipeOutputData outputData = new ViewRecipeOutputData(
                "Test Recipe", "Test Content", LocalDateTime.now(), 100, true, false
        );

        presenter.prepareSuccessView(outputData);

        // Verify that the ViewModel is updated with the output data
        verify(mockViewModel, times(1)).setTitle(outputData.getTitle());
        verify(mockViewModel, times(1)).setContent(outputData.getContent());
        // ... other verifications for each set method

        // Verify that firePropertyChanged is called on the ViewModel
        verify(mockViewModel, times(1)).firePropertyChanged();

        // Verify that the active view is set in the ViewManagerModel
        verify(mockViewManagerModel, times(1)).setActiveView(anyString());

        // Verify that firePropertyChanged is called on the ViewManagerModel
        verify(mockViewManagerModel, times(1)).firePropertyChanged();
    }

    @Test
    void prepareFailView_UpdatesViewModelWithErrorMessage() {
        String errorMessage = "No recipe found";

        presenter.prepareFailView(errorMessage);

        // Verify that the ViewModel is updated with the error message
        verify(mockViewModel, times(1)).setNoRecipeFoundMessage(errorMessage);

        // Verify that firePropertyChanged is called on the ViewModel
        verify(mockViewModel, times(1)).firePropertyChanged();
    }
}
