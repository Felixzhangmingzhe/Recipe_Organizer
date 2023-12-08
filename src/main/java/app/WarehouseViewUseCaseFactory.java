package app;

import data_access.FileRecipeDataAccessObject;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.click_search.ClickSearchViewModel;
import interface_adapter.view_recipe.ViewRecipeController;
import interface_adapter.view_recipe.ViewRecipePresenter;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import interface_adapter.view_warehouse.ViewWarehouseViewModel;
import interface_adapter.ViewManagerModel;

import use_case.Back.BackDataAccessInterface;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import use_case.view_recipe.ViewRecipeInputBoundary;
import use_case.view_recipe.ViewRecipeInteractor;

import view.WarehouseView;

public class WarehouseViewUseCaseFactory extends UseCaseFactory {
    public static WarehouseView create(ViewRecipeViewModel viewRecipeViewModel,
                                       ViewWarehouseViewModel viewWarehouseViewModel,
                                       ViewManagerModel viewManagerModel,
                                       FileRecipeDataAccessObject DAO,
                                       ClickSearchViewModel clickSearchViewModel,
                                       BackViewModel backViewModel) {
        ViewRecipeController viewRecipeController1 = createViewRecipeController(viewRecipeViewModel, viewManagerModel,DAO);
        BackController backController = createBackController(backViewModel, viewManagerModel,DAO);
        return new WarehouseView(viewRecipeController1, viewRecipeViewModel, backController,viewWarehouseViewModel,clickSearchViewModel,viewManagerModel);
    }

    private static ViewRecipeController createViewRecipeController(ViewRecipeViewModel viewRecipeViewModel,
                                                                   ViewManagerModel viewWarehouseViewModel,
                                                                   FileRecipeDataAccessObject DAO) {
        ViewRecipePresenter viewRecipeOutputBoundary = new ViewRecipePresenter(viewRecipeViewModel, viewWarehouseViewModel);
        ViewRecipeInputBoundary viewRecipeInputBoundary = new ViewRecipeInteractor(DAO, viewRecipeOutputBoundary);
        return new ViewRecipeController(viewRecipeInputBoundary);
    }
    private static BackController createBackController(BackViewModel backViewModel,
                                                       ViewManagerModel viewManagerModel,
                                                       BackDataAccessInterface DAO) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary,DAO);
        return new BackController(backInputBoundary);
    }
}