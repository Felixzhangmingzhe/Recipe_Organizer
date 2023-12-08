package app;

import data_access.FileRecipeDataAccessObject;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.view_favorites.ViewFavoritesViewModel;
import interface_adapter.view_recipe.ViewRecipeController;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import interface_adapter.view_recipe.ViewRecipePresenter;

import use_case.Back.BackDataAccessInterface;
import use_case.view_recipe.ViewRecipeInputBoundary;
import use_case.view_recipe.ViewRecipeInteractor;

import view.FavoritesView;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class FavoritesViewUseCaseFactoryTest {

    @Mock
    private ViewRecipeViewModel mockViewRecipeViewModel;

    @Mock
    private ViewManagerModel mockViewManagerModel;

    @Mock
    private BackViewModel mockBackViewModel;

    @Mock
    private ViewRecipeController mockViewRecipeController;

    @Mock
    private BackController mockBackController;

    @Mock
    private FileRecipeDataAccessObject mockDAO;

    @Mock
    private BackDataAccessInterface mockBackDAO;

    @Test
    public void testCreate() {
        // create the mock objects
        ViewManagerModel viewManagerModelMock = mock(ViewManagerModel.class);
        ViewRecipeViewModel viewRecipeViewModel = mock(ViewRecipeViewModel.class);
        ViewFavoritesViewModel viewFavoritesiewModel = mock(ViewFavoritesViewModel.class);
        FileRecipeDataAccessObject daoMock = mock(FileRecipeDataAccessObject.class);
        BackViewModel backViewModel = mock(BackViewModel.class);

        // create the object to be tested
        FavoritesView favoritesView = FavoritesViewUseCaseFactory.create(viewRecipeViewModel, viewManagerModelMock, viewFavoritesiewModel, daoMock, backViewModel);
        
        // verify the method calls
        mockViewRecipeController = mock(ViewRecipeController.class);
        verify(mockViewRecipeController, times(1)).execute(any());
    }
}
