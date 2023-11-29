package app;

import data_access.FileRecipeDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.open_create_recipe.OpenCreateRecipeController;
import interface_adapter.open_create_recipe.OpenCreateRecipePresenter;
import interface_adapter.open_create_recipe.OpenCreateRecipeViewModel;
import interface_adapter.view_favorites.ViewFavoritesController;
import interface_adapter.view_favorites.ViewFavoritesPresenter;
import interface_adapter.view_favorites.ViewFavoritesViewModel;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import interface_adapter.view_warehouse.ViewWarehouseController;
import interface_adapter.view_warehouse.ViewWarehousePresenter;
import interface_adapter.view_warehouse.ViewWarehouseViewModel;
import use_case.open_create_recipe.OpenCreateRecipeDataAccessInterface;
import use_case.open_create_recipe.OpenCreateRecipeInputBoundary;
import use_case.open_create_recipe.OpenCreateRecipeInteractor;
import use_case.open_create_recipe.OpenCreateRecipeOutputBoundary;
import use_case.view_favorites.ViewFavoritesDataAccessInterface;
import use_case.view_favorites.ViewFavoritesInputBoundary;
import use_case.view_favorites.ViewFavoritesInteractor;
import use_case.view_favorites.ViewFavoritesOutputBoundary;
import use_case.view_warehouse.ViewWarehouseDataAccessInterface;
import use_case.view_warehouse.ViewWarehouseInputBoundary;
import use_case.view_warehouse.ViewWarehouseInteractor;
import use_case.view_warehouse.ViewWarehouseOutputBoundary;
import view.MainView;

public class MainViewUseCaseFactory {
    public static MainView create(ViewManagerModel viewManagerModel, ViewWarehouseViewModel viewWarehouseViewModel, ViewFavoritesViewModel viewFavoritesViewModel,
                                    OpenCreateRecipeViewModel openCreateRecipeViewModel,
                                  FileRecipeDataAccessObject dao, ViewRecipeViewModel viewRecipeViewModel) {
        try {
            // 生成各个用例的Controller
            ViewWarehouseController viewWarehouseController = createViewWarehouseController(viewManagerModel, viewWarehouseViewModel, dao, viewRecipeViewModel);
            ViewFavoritesController viewFavoritesController = createViewFavoritesController(viewManagerModel, viewFavoritesViewModel, dao, viewRecipeViewModel);
            OpenCreateRecipeController openCreateRecipeController = createOpenCreateRecipeController(viewManagerModel, openCreateRecipeViewModel, dao);

            return new MainView(viewWarehouseController, viewWarehouseViewModel, viewFavoritesController, viewFavoritesViewModel, openCreateRecipeViewModel, openCreateRecipeController,viewManagerModel);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private static ViewFavoritesController createViewFavoritesController(ViewManagerModel viewManagerModel, ViewFavoritesViewModel viewFavoritesViewModel, FileRecipeDataAccessObject dao, ViewRecipeViewModel viewRecipeViewModel) {
        ViewFavoritesOutputBoundary viewFavoritesOutputBoundary = new ViewFavoritesPresenter(viewFavoritesViewModel, viewManagerModel, viewRecipeViewModel);
        ViewFavoritesInputBoundary viewFavoritesInputBoundary = new ViewFavoritesInteractor((ViewFavoritesPresenter) viewFavoritesOutputBoundary, (ViewFavoritesDataAccessInterface) dao);
        return new ViewFavoritesController(viewFavoritesInputBoundary);
    }
    private static ViewWarehouseController createViewWarehouseController(ViewManagerModel viewManagerModel, ViewWarehouseViewModel viewWarehouseViewModel, FileRecipeDataAccessObject dao, ViewRecipeViewModel viewRecipeViewModel) {
        ViewWarehouseOutputBoundary viewWarehouseOutputBoundary = (ViewWarehouseOutputBoundary) new ViewWarehousePresenter(viewWarehouseViewModel, viewRecipeViewModel, viewManagerModel);
        ViewWarehouseInputBoundary viewWarehouseInputBoundary = new ViewWarehouseInteractor((ViewWarehousePresenter) viewWarehouseOutputBoundary, (ViewWarehouseDataAccessInterface) dao);
        return new ViewWarehouseController(viewWarehouseInputBoundary);
    }
    private static OpenCreateRecipeController createOpenCreateRecipeController(ViewManagerModel viewManagerModel, OpenCreateRecipeViewModel openCreateRecipeViewModel, FileRecipeDataAccessObject dao) {
        OpenCreateRecipeOutputBoundary openCreateRecipeOutputBoundary = new OpenCreateRecipePresenter(openCreateRecipeViewModel,viewManagerModel);
        OpenCreateRecipeInputBoundary openCreateRecipeInputBoundary = new OpenCreateRecipeInteractor((OpenCreateRecipeOutputBoundary) openCreateRecipeOutputBoundary, (OpenCreateRecipeDataAccessInterface) dao);
        return new OpenCreateRecipeController(openCreateRecipeInputBoundary);
    }
}
