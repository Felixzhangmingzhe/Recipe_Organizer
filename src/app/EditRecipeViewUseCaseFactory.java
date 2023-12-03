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
import interface_adapter.edit_recipe.EditRecipeController;
import interface_adapter.edit_recipe.EditRecipePresenter;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.jump_to_edit.JumpToEditViewModel;
import interface_adapter.open_create_recipe.OpenCreateRecipeViewModel;
import use_case.Back.BackDataAccessInterface;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import use_case.create_recipe.CreateRecipeInputBoundary;
import use_case.create_recipe.CreateRecipeInteractor;
import use_case.create_recipe.CreateRecipeOutputBoundary;
import use_case.create_recipe.CreateRecipeUserDataAccessInterface;
import use_case.edit_recipe.EditRecipeDataAccessInterface;
import use_case.edit_recipe.EditRecipeInputBoundary;
import use_case.edit_recipe.EditRecipeInteractor;
import use_case.edit_recipe.EditRecipeOutputBoundary;
import view.EditRecipeView;

public class EditRecipeViewUseCaseFactory extends UseCaseFactory {
    public static EditRecipeView create(BackViewModel backViewModel, ViewManagerModel viewManagerModel, CreateRecipeViewModel createRecipeViewModel, OpenCreateRecipeViewModel openCreateRecipeViewModel, EditRecipeViewModel editRecipeViewModel,JumpToEditViewModel jumpToEditViewModel, FileRecipeDataAccessObject dao) {
        BackController backController = createBackController(backViewModel, viewManagerModel,dao);
        CreateRecipeController createRecipeController = createCreateRecipeController(createRecipeViewModel, viewManagerModel, dao);
        EditRecipeController editRecipeController = createEditRecipeController(editRecipeViewModel, viewManagerModel, dao);
        return new EditRecipeView(backController, backViewModel, jumpToEditViewModel, openCreateRecipeViewModel, editRecipeViewModel,editRecipeController, createRecipeController, createRecipeViewModel);
    }

    private static EditRecipeController createEditRecipeController(EditRecipeViewModel editRecipeViewModel, ViewManagerModel viewManagerModel, FileRecipeDataAccessObject dao) {
        EditRecipeOutputBoundary editRecipeOutputBoundary = (EditRecipeOutputBoundary) new EditRecipePresenter(editRecipeViewModel, viewManagerModel);
        EditRecipeInputBoundary editRecipeInputBoundary = new EditRecipeInteractor((EditRecipeDataAccessInterface) dao,editRecipeOutputBoundary);
        return new EditRecipeController(editRecipeInputBoundary);
    }


    private static CreateRecipeController createCreateRecipeController(CreateRecipeViewModel createRecipeViewModel, ViewManagerModel viewManagerModel, CreateRecipeUserDataAccessInterface dao) {
        CreateRecipeOutputBoundary createRecipeOutputBoundary = (CreateRecipeOutputBoundary) new CreateRecipePresenter(createRecipeViewModel, viewManagerModel);
        RecipeFactory recipeFactory = new RecipeFactory();
        CreateRecipeInputBoundary createRecipeInputBoundary = new CreateRecipeInteractor(createRecipeOutputBoundary, dao, recipeFactory);
        return new CreateRecipeController(createRecipeInputBoundary);
    }

    public static BackController createBackController(BackViewModel backViewModel, ViewManagerModel viewManagerModel, BackDataAccessInterface dao) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary,dao);
        return new BackController(backInputBoundary);
    }
}