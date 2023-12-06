package app;

import data_access.FileRecipeDataAccessObject;

import use_case.open_create_recipe.OpenCreateRecipeInputBoundary;
import use_case.open_create_recipe.OpenCreateRecipeInteractor;
import use_case.open_create_recipe.OpenCreateRecipeOutputBoundary;
import use_case.show_daily_special.ShowDailySpecialInputBoundary;
import use_case.show_daily_special.ShowDailySpecialInteractor;
import use_case.show_daily_special.ShowDailySpecialOutputBoundary;
import use_case.view_favorites.ViewFavoritesInputBoundary;
import use_case.view_favorites.ViewFavoritesInteractor;
import use_case.view_warehouse.ViewWarehouseInputBoundary;
import use_case.view_warehouse.ViewWarehouseInteractor;
import use_case.view_search.ViewSearchInputBoundary;
import use_case.view_search.ViewSearchInteractor;

import interface_adapter.Back.BackViewModel;
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
import interface_adapter.ViewManagerModel;

import view.MainView;

public class MainViewUseCaseFactory extends UseCaseFactory {
    public static MainView create(ViewManagerModel viewManagerModel, ViewWarehouseViewModel viewWarehouseViewModel, ViewFavoritesViewModel viewFavoritesViewModel,
                                  OpenCreateRecipeViewModel openCreateRecipeViewModel, BackViewModel backViewModel,
                                  FileRecipeDataAccessObject DAO, ViewRecipeViewModel viewRecipeViewModel, ViewSearchViewModel viewSearchViewModel,
                                  ShowDailySpecialViewModel showDailySpecialViewModel) {
        try {
            // 生成各个用例的Controller
            ViewWarehouseController viewWarehouseController = createViewWarehouseController(viewManagerModel, viewWarehouseViewModel, DAO, viewRecipeViewModel);
            ViewFavoritesController viewFavoritesController = createViewFavoritesController(viewManagerModel, viewFavoritesViewModel, DAO, viewRecipeViewModel);
            ViewSearchController viewSearchController = createViewSearchController(viewManagerModel, viewSearchViewModel);
            OpenCreateRecipeController openCreateRecipeController = createOpenCreateRecipeController(viewManagerModel, openCreateRecipeViewModel, DAO);
            ShowDailySpecialController showDailySpecialController = createShowDailySpecialController(viewManagerModel, showDailySpecialViewModel, DAO);

            return new MainView(viewWarehouseController, viewWarehouseViewModel, viewFavoritesController, viewFavoritesViewModel, openCreateRecipeViewModel, openCreateRecipeController,viewManagerModel, viewSearchController, viewSearchViewModel,
                    backViewModel,
                    showDailySpecialViewModel, showDailySpecialController);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static ViewFavoritesController createViewFavoritesController(ViewManagerModel viewManagerModel, ViewFavoritesViewModel viewFavoritesViewModel, FileRecipeDataAccessObject DAO, ViewRecipeViewModel viewRecipeViewModel) {
        ViewFavoritesPresenter viewFavoritesOutputBoundary = new ViewFavoritesPresenter(viewFavoritesViewModel, viewManagerModel, viewRecipeViewModel);
        ViewFavoritesInputBoundary viewFavoritesInputBoundary = new ViewFavoritesInteractor(DAO, viewFavoritesOutputBoundary);
        return new ViewFavoritesController(viewFavoritesInputBoundary);
    }

    private static ViewWarehouseController createViewWarehouseController(ViewManagerModel viewManagerModel, ViewWarehouseViewModel viewWarehouseViewModel, FileRecipeDataAccessObject DAO, ViewRecipeViewModel viewRecipeViewModel) {
        ViewWarehousePresenter viewWarehouseOutputBoundary = new ViewWarehousePresenter(viewWarehouseViewModel, viewRecipeViewModel, viewManagerModel);
        ViewWarehouseInputBoundary viewWarehouseInputBoundary = new ViewWarehouseInteractor(DAO, viewWarehouseOutputBoundary);
        return new ViewWarehouseController(viewWarehouseInputBoundary);
    }

    private static OpenCreateRecipeController createOpenCreateRecipeController(ViewManagerModel viewManagerModel, OpenCreateRecipeViewModel openCreateRecipeViewModel, FileRecipeDataAccessObject DAO) {
        OpenCreateRecipeOutputBoundary openCreateRecipeOutputBoundary = new OpenCreateRecipePresenter(openCreateRecipeViewModel,viewManagerModel);
        OpenCreateRecipeInputBoundary openCreateRecipeInputBoundary = new OpenCreateRecipeInteractor(openCreateRecipeOutputBoundary, DAO);
        return new OpenCreateRecipeController(openCreateRecipeInputBoundary);
    }

    private static ShowDailySpecialController createShowDailySpecialController(ViewManagerModel viewManagerModel, ShowDailySpecialViewModel showDailySpecialViewModel, FileRecipeDataAccessObject DAO) {
        ShowDailySpecialOutputBoundary showDailySpecialOutputBoundary = new ShowDailySpecialPresenter(showDailySpecialViewModel,viewManagerModel);
        ShowDailySpecialInputBoundary showDailySpecialInputBoundary = new ShowDailySpecialInteractor(showDailySpecialOutputBoundary, DAO);
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
