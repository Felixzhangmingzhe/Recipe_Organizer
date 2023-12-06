package app;

import entity.RecipeFactory;

import data_access.FileRecipeDataAccessObject;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.create_recipe.CreateRecipeController;
import interface_adapter.create_recipe.CreateRecipePresenter;
import interface_adapter.create_recipe.CreateRecipeViewModel;
import interface_adapter.edit_recipe.EditRecipeController;
import interface_adapter.edit_recipe.EditRecipePresenter;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.jump_to_edit.JumpToEditViewModel;
import interface_adapter.open_create_recipe.OpenCreateRecipeViewModel;
import interface_adapter.ViewManagerModel;

import use_case.Back.BackDataAccessInterface;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import use_case.create_recipe.CreateRecipeInputBoundary;
import use_case.create_recipe.CreateRecipeInteractor;
import use_case.create_recipe.CreateRecipeOutputBoundary;
import use_case.create_recipe.CreateRecipeUserDataAccessInterface;
import use_case.edit_recipe.EditRecipeInputBoundary;
import use_case.edit_recipe.EditRecipeInteractor;
import use_case.edit_recipe.EditRecipeOutputBoundary;

import view.EditRecipeView;

public class EditRecipeViewUseCaseFactory extends UseCaseFactory {
    public static BackController createBackController(BackViewModel backViewModel, ViewManagerModel viewManagerModel, BackDataAccessInterface DAO) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary,DAO);
        return new BackController(backInputBoundary);
    }

    private static CreateRecipeController createCreateRecipeController(CreateRecipeViewModel createRecipeViewModel, ViewManagerModel viewManagerModel, CreateRecipeUserDataAccessInterface DAO) {
        CreateRecipeOutputBoundary createRecipeOutputBoundary = new CreateRecipePresenter(createRecipeViewModel, viewManagerModel);
        RecipeFactory recipeFactory = new RecipeFactory();
        CreateRecipeInputBoundary createRecipeInputBoundary = new CreateRecipeInteractor(createRecipeOutputBoundary, DAO, recipeFactory);
        return new CreateRecipeController(createRecipeInputBoundary);
    }

    private static EditRecipeController createEditRecipeController(EditRecipeViewModel editRecipeViewModel, ViewManagerModel viewManagerModel, FileRecipeDataAccessObject DAO) {
        EditRecipeOutputBoundary editRecipeOutputBoundary = new EditRecipePresenter(editRecipeViewModel, viewManagerModel);
        EditRecipeInputBoundary editRecipeInputBoundary = new EditRecipeInteractor(DAO,editRecipeOutputBoundary);
        return new EditRecipeController(editRecipeInputBoundary);
    }

    public static EditRecipeView create(BackViewModel backViewModel, ViewManagerModel viewManagerModel, CreateRecipeViewModel createRecipeViewModel, OpenCreateRecipeViewModel openCreateRecipeViewModel, EditRecipeViewModel editRecipeViewModel,JumpToEditViewModel jumpToEditViewModel, FileRecipeDataAccessObject DAO) {
        BackController backController = createBackController(backViewModel, viewManagerModel, DAO);
        CreateRecipeController createRecipeController = createCreateRecipeController(createRecipeViewModel, viewManagerModel, DAO);
        EditRecipeController editRecipeController = createEditRecipeController(editRecipeViewModel, viewManagerModel, DAO);
        return new EditRecipeView(backController, backViewModel, createRecipeController, createRecipeViewModel, editRecipeController, editRecipeViewModel, jumpToEditViewModel, openCreateRecipeViewModel);
    }
}