package app;

import data_access.FileRecipeDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.open_create_recipe.OpenCreateRecipeController;
import interface_adapter.open_create_recipe.OpenCreateRecipePresenter;
import interface_adapter.open_create_recipe.OpenCreateRecipeViewModel;
import interface_adapter.show_daily_special.ShowDailySpecialController;
import interface_adapter.show_daily_special.ShowDailySpecialPresenter;
import interface_adapter.show_daily_special.ShowDailySpecialViewModel;
import interface_adapter.view_favorites.ViewFavoritesController;
import interface_adapter.view_favorites.ViewFavoritesPresenter;
import interface_adapter.view_favorites.ViewFavoritesViewModel;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import interface_adapter.view_search.ViewSearchController;
import interface_adapter.view_search.ViewSearchPresenter;
import interface_adapter.view_search.ViewSearchViewModel;
import interface_adapter.view_warehouse.ViewWarehouseController;
import interface_adapter.view_warehouse.ViewWarehousePresenter;
import interface_adapter.view_warehouse.ViewWarehouseViewModel;
import use_case.open_create_recipe.OpenCreateRecipeDataAccessInterface;
import use_case.open_create_recipe.OpenCreateRecipeInputBoundary;
import use_case.open_create_recipe.OpenCreateRecipeInteractor;
import use_case.open_create_recipe.OpenCreateRecipeOutputBoundary;
import use_case.show_daily_special.ShowDailySpecialDataAccessInterface;
import use_case.show_daily_special.ShowDailySpecialInputBoundary;
import use_case.show_daily_special.ShowDailySpecialInteractor;
import use_case.show_daily_special.ShowDailySpecialOutputBoundary;
import use_case.view_favorites.ViewFavoritesDataAccessInterface;
import use_case.view_favorites.ViewFavoritesInputBoundary;
import use_case.view_favorites.ViewFavoritesInteractor;
import use_case.view_favorites.ViewFavoritesOutputBoundary;

import use_case.view_warehouse.ViewWarehouseDataAccessInterface;
import use_case.view_warehouse.ViewWarehouseInputBoundary;
import use_case.view_warehouse.ViewWarehouseInteractor;
import use_case.view_warehouse.ViewWarehouseOutputBoundary;

import use_case.view_search.ViewSearchInputBoundary;
import use_case.view_search.ViewSearchOutputBoundary;
import use_case.view_search.ViewSearchInteractor;

import view.MainView;

public class MainViewUseCaseFactory extends UseCaseFactory {
    public static MainView create(ViewManagerModel viewManagerModel, ViewWarehouseViewModel viewWarehouseViewModel, ViewFavoritesViewModel viewFavoritesViewModel,
                                  OpenCreateRecipeViewModel openCreateRecipeViewModel,
                                  FileRecipeDataAccessObject dao, ViewRecipeViewModel viewRecipeViewModel, ViewSearchViewModel viewSearchViewModel,
                                  ShowDailySpecialViewModel showDailySpecialViewModel) {
        try {
            // 生成各个用例的Controller
            ViewWarehouseController viewWarehouseController = createViewWarehouseController(viewManagerModel, viewWarehouseViewModel, dao, viewRecipeViewModel);
            ViewFavoritesController viewFavoritesController = createViewFavoritesController(viewManagerModel, viewFavoritesViewModel, dao, viewRecipeViewModel);
            ViewSearchController viewSearchController = createViewSearchController(viewManagerModel, viewSearchViewModel);
            OpenCreateRecipeController openCreateRecipeController = createOpenCreateRecipeController(viewManagerModel, openCreateRecipeViewModel, dao);
            ShowDailySpecialController showDailySpecialController = createShowDailySpecialController(viewManagerModel, showDailySpecialViewModel, dao);

            return new MainView(viewWarehouseController, viewWarehouseViewModel, viewFavoritesController, viewFavoritesViewModel, openCreateRecipeViewModel, openCreateRecipeController,viewManagerModel, viewSearchController, viewSearchViewModel,
                    showDailySpecialViewModel, showDailySpecialController);
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

    private static ShowDailySpecialController createShowDailySpecialController(ViewManagerModel viewManagerModel, ShowDailySpecialViewModel showDailySpecialViewModel, FileRecipeDataAccessObject dao) {
        ShowDailySpecialOutputBoundary showDailySpecialOutputBoundary = (ShowDailySpecialOutputBoundary) new ShowDailySpecialPresenter(showDailySpecialViewModel,viewManagerModel);
        ShowDailySpecialInputBoundary showDailySpecialInputBoundary = new ShowDailySpecialInteractor((ShowDailySpecialOutputBoundary) showDailySpecialOutputBoundary, (ShowDailySpecialDataAccessInterface) dao);
        return new ShowDailySpecialController(showDailySpecialInputBoundary);
    }

    static ViewSearchController createViewSearchController(ViewManagerModel viewManagerModel, ViewSearchViewModel viewSearchViewModel) {
        ViewSearchPresenter viewSearchOutputBoundary = new ViewSearchPresenter(viewSearchViewModel, viewManagerModel);
        ViewSearchInputBoundary viewSearchInputBoundary = new ViewSearchInteractor(viewSearchOutputBoundary);
        return new ViewSearchController(viewSearchInputBoundary);
    }

    static ViewSearchController createViewNewSearchController(ViewManagerModel viewManagerModel, ViewSearchViewModel viewSearchViewModel) {
        ViewSearchPresenter viewSearchOutputBoundary = new ViewSearchPresenter(viewSearchViewModel, viewManagerModel);
        ViewSearchInputBoundary viewSearchInputBoundary = new ViewSearchInteractor(viewSearchOutputBoundary);
        return new ViewSearchController(viewSearchInputBoundary);
    }
}
