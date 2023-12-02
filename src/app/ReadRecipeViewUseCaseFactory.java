package app;

import data_access.FileRecipeDataAccessObject;
import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_to_favorites.AddToFavoritesController;
import interface_adapter.add_to_favorites.AddToFavoritesPresenter;
import interface_adapter.add_to_favorites.AddToFavoritesViewModel;
import interface_adapter.create_recipe.CreateRecipeController;
import interface_adapter.create_recipe.CreateRecipeViewModel;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import use_case.add_to_favorites.AddToFavoritesInputBoundary;
import use_case.add_to_favorites.AddToFavoritesInteractor;
import use_case.add_to_favorites.AddToFavoritesOutputBoundary;
import view.ReadRecipeView;

public class ReadRecipeViewUseCaseFactory extends UseCaseFactory {
    public static ReadRecipeView create(BackViewModel backViewModel, ViewManagerModel viewManagerModel,
                                        CreateRecipeViewModel createRecipeViewModel,
                                        ViewRecipeViewModel viewRecipeViewModel,
                                        AddToFavoritesViewModel addToFavoritesViewModel,
                                        FileRecipeDataAccessObject dao) {
        BackController backController = createBackController(backViewModel, viewManagerModel);
        AddToFavoritesController addToFavotitesController = createAddToFavoritesController(addToFavoritesViewModel, viewManagerModel, dao);
        return new ReadRecipeView(backViewModel, backController,viewRecipeViewModel, createRecipeViewModel, addToFavotitesController, addToFavoritesViewModel);
    }

    private static AddToFavoritesController createAddToFavoritesController(AddToFavoritesViewModel addToFavoritesViewModel, ViewManagerModel viewManagerModel, FileRecipeDataAccessObject dao) {
        AddToFavoritesOutputBoundary addToFavoritesOutputBoundary = new AddToFavoritesPresenter(addToFavoritesViewModel, viewManagerModel);
        AddToFavoritesInputBoundary addToFavoritesInputBoundary = new AddToFavoritesInteractor(dao, addToFavoritesOutputBoundary);
        return new AddToFavoritesController(addToFavoritesInputBoundary);
    }

    public static BackController createBackController(BackViewModel backViewModel, ViewManagerModel viewManagerModel) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary);
        return new BackController(backInputBoundary);
    }
}
