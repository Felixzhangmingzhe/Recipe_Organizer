package app;

import data_access.FileRecipeDataAccessObject;
import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_to_favorites.AddToFavoritesController;
import interface_adapter.add_to_favorites.AddToFavoritesPresenter;
import interface_adapter.add_to_favorites.AddToFavoritesViewModel;
import interface_adapter.cooked.CookedController;
import interface_adapter.cooked.CookedPresenter;
import interface_adapter.cooked.CookedViewModel;
import interface_adapter.create_recipe.CreateRecipeController;
import interface_adapter.create_recipe.CreateRecipeViewModel;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import use_case.add_to_favorites.AddToFavoritesInputBoundary;
import use_case.add_to_favorites.AddToFavoritesInteractor;
import use_case.add_to_favorites.AddToFavoritesOutputBoundary;
import use_case.cooked.CookedInputBoundary;
import use_case.cooked.CookedOutputBoundary;
import view.ReadRecipeView;

public class ReadRecipeViewUseCaseFactory extends UseCaseFactory {
    public static ReadRecipeView create(BackViewModel backViewModel, ViewManagerModel viewManagerModel,
                                        CreateRecipeViewModel createRecipeViewModel,
                                        ViewRecipeViewModel viewRecipeViewModel,
                                        AddToFavoritesViewModel addToFavoritesViewModel,
                                        CookedViewModel cookedViewModel,
                                        FileRecipeDataAccessObject dao) {
        BackController backController = createBackController(backViewModel, viewManagerModel);
        AddToFavoritesController addToFavotitesController = createAddToFavoritesController(addToFavoritesViewModel, viewManagerModel, dao);
        CookedController cookedController = createCookedController(cookedViewModel, viewManagerModel, dao);
        return new ReadRecipeView(backViewModel, backController,viewRecipeViewModel, createRecipeViewModel, addToFavotitesController, addToFavoritesViewModel, cookedViewModel, cookedController);
    }

    private static CookedController createCookedController(CookedViewModel cookedViewModel, ViewManagerModel viewManagerModel, FileRecipeDataAccessObject dao) {
        CookedOutputBoundary cookedOutputBoundary = new CookedPresenter(cookedViewModel, viewManagerModel);
        CookedInputBoundary cookedInputBoundary = new use_case.cooked.CookedInteractor(cookedOutputBoundary, dao);
        return new CookedController(cookedInputBoundary);
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
