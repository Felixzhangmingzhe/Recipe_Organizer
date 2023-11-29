package app;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_recipe.CreateRecipeController;
import interface_adapter.create_recipe.CreateRecipePresenter;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import use_case.create_recipe.CreateRecipeOutputBoundary;
import view.EditRecipeView;

public class EditRecipeViewUseCaseFactory {
    public static EditRecipeView create(BackViewModel backViewModel,ViewManagerModel viewManagerModel) {
        BackController backController = createBackController(backViewModel, viewManagerModel);
        CreateRecipeController createRecipeController = createCreateRecipeController(backViewModel);
        return new EditRecipeView(backController, backViewModel);
    }

    private static CreateRecipeController createCreateRecipeController(BackViewModel backViewModel) {
        CreateRecipeOutputBoundary createRecipeOutputBoundary = new CreateRecipePresenter(
    }

    public static BackController createBackController(BackViewModel backViewModel, ViewManagerModel viewManagerModel) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary);
        return new BackController(backInputBoundary);
    }
}
