package app;

import data_access.FileRecipeDataAccessObject;
import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.view_favorites.ViewFavoritesViewModel;
import interface_adapter.view_recipe.ViewRecipeController;
import interface_adapter.view_recipe.ViewRecipePresenter;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import use_case.Back.BackDataAccessInterface;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import use_case.view_recipe.ViewRecipeInputBoundary;
import use_case.view_recipe.ViewRecipeInteractor;
import use_case.view_recipe.ViewRecipeOutputBoundary;
import view.FavoritesView;
import view.WarehouseView;



public class FavoritesViewUseCaseFactory extends UseCaseFactory {
    public static FavoritesView create(ViewRecipeViewModel viewRecipeViewModel,
                                       ViewManagerModel viewManagerModel,
                                       ViewFavoritesViewModel viewFavoritesViewModel,
                                       FileRecipeDataAccessObject dao, BackViewModel backViewModel) {
        ViewRecipeController viewRecipeController1 = createViewRecipeController(viewRecipeViewModel, viewManagerModel, dao);
        BackController backController = createBackController(backViewModel, viewManagerModel,dao);
        return new FavoritesView(viewRecipeController1, viewRecipeViewModel, backController,viewFavoritesViewModel,viewManagerModel);
    }


    private static ViewRecipeController createViewRecipeController(ViewRecipeViewModel viewRecipeViewModel,
                                                                   ViewManagerModel viewWarehouseViewModel,
                                                                   FileRecipeDataAccessObject dao) {
        ViewRecipeOutputBoundary viewRecipeOutputBoundary = new ViewRecipePresenter(viewRecipeViewModel, viewWarehouseViewModel);
        ViewRecipeInputBoundary viewRecipeInputBoundary = new ViewRecipeInteractor(dao, (ViewRecipePresenter) viewRecipeOutputBoundary);
        return new ViewRecipeController(viewRecipeInputBoundary);
    }


    private static BackController createBackController(BackViewModel backViewModel, ViewManagerModel viewManagerModel, BackDataAccessInterface dao) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary,dao);
        return new BackController(backInputBoundary);

    }
}

