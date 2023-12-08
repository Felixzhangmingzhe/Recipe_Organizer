package app;

import data_access.FileRecipeDataAccessObject;

import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.click_search.ClickSearchViewModel;
import interface_adapter.view_favorites.ViewFavoritesViewModel;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import interface_adapter.view_warehouse.ViewWarehouseViewModel;

import view.FavoritesView;
import view.SearchNewView;
import view.SearchView;
import view.WarehouseView;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class MainTest {

    @Mock
    private ViewRecipeViewModel mockViewRecipeViewModel;

    @Mock
    private ViewManagerModel mockViewManagerModel;

    @Mock
    private BackViewModel mockBackViewModel;

    @Test
    public void testMain() throws JSONException {
        MockitoAnnotations.initMocks(this);

        Main main = new Main();
        main.main(new String[0]);
        mockBackViewModel = mock(BackViewModel.class);
        mockViewManagerModel = mock(ViewManagerModel.class);
        mockViewRecipeViewModel = mock(ViewRecipeViewModel.class);
        ViewFavoritesViewModel viewFavoritesViewModel = mock(ViewFavoritesViewModel.class);
        ViewWarehouseViewModel viewWarehouseViewModel = mock(ViewWarehouseViewModel.class);
        ClickSearchViewModel clickSearchViewModel = mock(ClickSearchViewModel.class);
        // In this example, I'm just testing a small part of the Main class.
        // You can extend it according to your specific needs.

        // For example, you can check if certain views are created and added to the viewManagerModel.

        // You can also consider using UI testing frameworks for more comprehensive tests.

        // Below is a simple assertion for the creation of FavoritesView.
        FavoritesView favoritesView = FavoritesViewUseCaseFactory.create(
                mockViewRecipeViewModel, mockViewManagerModel, viewFavoritesViewModel,
                mock(FileRecipeDataAccessObject.class), mockBackViewModel
        );
        WarehouseView warehouseView = WarehouseViewUseCaseFactory.create(
                mockViewRecipeViewModel,  viewWarehouseViewModel,mockViewManagerModel,
                mock(FileRecipeDataAccessObject.class), clickSearchViewModel, mockBackViewModel
        );
        SearchNewView searchNewView = SearchNewViewUseCaseFactory.create(
        );

        assertNotNull(favoritesView);
        assertNotNull(warehouseView);
    }
}
