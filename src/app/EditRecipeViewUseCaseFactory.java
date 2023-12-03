package app;

import data_access.FileRecipeDataAccessObject;
import entity.RecipeFactory;
import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_recipe.CreateRecipeController;
import interface_adapter.create_recipe.CreateRecipePresenter;
import interface_adapter.create_recipe.CreateRecipeViewModel;
import interface_adapter.jump_to_edit.JumpToEditViewModel;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import use_case.create_recipe.CreateRecipeInputBoundary;
import use_case.create_recipe.CreateRecipeInteractor;
import use_case.create_recipe.CreateRecipeOutputBoundary;
import use_case.create_recipe.CreateRecipeUserDataAccessInterface;
import view.EditRecipeView;

public class EditRecipeViewUseCaseFactory extends UseCaseFactory {
    public static EditRecipeView create(BackViewModel backViewModel, ViewManagerModel viewManagerModel, CreateRecipeViewModel createRecipeViewModel, JumpToEditViewModel jumpToEditViewModel, FileRecipeDataAccessObject dao) {
        BackController backController = createBackController(backViewModel, viewManagerModel);
        CreateRecipeController createRecipeController = createCreateRecipeController(createRecipeViewModel, viewManagerModel, dao);
        return new EditRecipeView(backController, backViewModel, jumpToEditViewModel, createRecipeController, createRecipeViewModel);
    }

    private static CreateRecipeController createCreateRecipeController(CreateRecipeViewModel createRecipeViewModel, ViewManagerModel viewManagerModel, CreateRecipeUserDataAccessInterface dao) {
        CreateRecipeOutputBoundary createRecipeOutputBoundary = (CreateRecipeOutputBoundary) new CreateRecipePresenter(createRecipeViewModel, viewManagerModel);
        RecipeFactory recipeFactory = new RecipeFactory();
        CreateRecipeInputBoundary createRecipeInputBoundary = new CreateRecipeInteractor(createRecipeOutputBoundary, dao, recipeFactory);
        return new CreateRecipeController(createRecipeInputBoundary);
    }

    public static BackController createBackController(BackViewModel backViewModel, ViewManagerModel viewManagerModel) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary);
        return new BackController(backInputBoundary);
    }
}