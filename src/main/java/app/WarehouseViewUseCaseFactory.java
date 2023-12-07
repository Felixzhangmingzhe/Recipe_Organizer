package app;

import data_access.FileRecipeDataAccessObject;
import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.click_search.ClickSearchViewModel;
import interface_adapter.view_recipe.ViewRecipeController;
import interface_adapter.view_recipe.ViewRecipePresenter;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import interface_adapter.view_warehouse.ViewWarehouseViewModel;
import use_case.Back.BackDataAccessInterface;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import use_case.view_recipe.ViewRecipeInputBoundary;
import use_case.view_recipe.ViewRecipeInteractor;
import view.WarehouseView;

public class WarehouseViewUseCaseFactory extends UseCaseFactory {
    public static WarehouseView create(ViewRecipeViewModel viewRecipeViewModel, ViewWarehouseViewModel viewWarehouseViewModel,
                                       ViewManagerModel viewManagerModel, FileRecipeDataAccessObject dao, ClickSearchViewModel clickSearchViewModel,
                                       BackViewModel backViewModel) {
        ViewRecipeController viewRecipeController1 = createViewRecipeController(viewRecipeViewModel, viewManagerModel,dao);
        BackController backController = createBackController(backViewModel, viewManagerModel,dao);
        return new WarehouseView(viewRecipeController1, viewRecipeViewModel, backController,viewWarehouseViewModel,clickSearchViewModel,viewManagerModel);
    }

    private static ViewRecipeController createViewRecipeController(ViewRecipeViewModel viewRecipeViewModel, ViewManagerModel viewWarehouseViewModel, FileRecipeDataAccessObject dao) {
        ViewRecipePresenter viewRecipeOutputBoundary = new ViewRecipePresenter(viewRecipeViewModel, viewWarehouseViewModel);
        ViewRecipeInputBoundary viewRecipeInputBoundary = new ViewRecipeInteractor(dao, viewRecipeOutputBoundary);
        return new ViewRecipeController(viewRecipeInputBoundary);
    }
    private static BackController createBackController(BackViewModel backViewModel, ViewManagerModel viewManagerModel, BackDataAccessInterface dao) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary,dao);
        return new BackController(backInputBoundary);
    }
}