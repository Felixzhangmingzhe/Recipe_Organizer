package app;

import data_access.FileRecipeDataAccessObject;
import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_recipe.CreateRecipeController;
import interface_adapter.create_recipe.CreateRecipeViewModel;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import view.ReadRecipeView;

public class ReadRecipeViewUseCaseFactory extends UseCaseFactory {
    public static ReadRecipeView create(BackViewModel backViewModel, ViewManagerModel viewManagerModel,
                                        CreateRecipeViewModel createRecipeViewModel,
                                        ViewRecipeViewModel viewRecipeViewModel,
                                        FileRecipeDataAccessObject dao) {
        BackController backController = createBackController(backViewModel, viewManagerModel);

        return new ReadRecipeView(backViewModel, backController,viewRecipeViewModel,createRecipeViewModel);
    }
    public static BackController createBackController(BackViewModel backViewModel, ViewManagerModel viewManagerModel) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary);
        return new BackController(backInputBoundary);
    }
}
