package app;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.add_to_favorites.AddToFavoritesController;
import interface_adapter.add_to_favorites.AddToFavoritesPresenter;
import interface_adapter.add_to_favorites.AddToFavoritesViewModel;
import interface_adapter.cooked.CookedController;
import interface_adapter.cooked.CookedPresenter;
import interface_adapter.cooked.CookedViewModel;
import interface_adapter.create_recipe.CreateRecipeViewModel;
import interface_adapter.edit_recipe.EditRecipeViewModel;
import interface_adapter.jump_to_edit.JumpToEditController;
import interface_adapter.jump_to_edit.JumpToEditPresenter;
import interface_adapter.jump_to_edit.JumpToEditViewModel;
import interface_adapter.show_daily_special.ShowDailySpecialController;
import interface_adapter.show_daily_special.ShowDailySpecialPresenter;
import interface_adapter.show_daily_special.ShowDailySpecialViewModel;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import interface_adapter.ViewManagerModel;

import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import use_case.add_to_favorites.AddToFavoritesInputBoundary;
import use_case.add_to_favorites.AddToFavoritesInteractor;
import use_case.add_to_favorites.AddToFavoritesOutputBoundary;
import use_case.cooked.CookedInputBoundary;
import use_case.cooked.CookedOutputBoundary;
import use_case.jump_to_edit.JumpToEditInputBoundary;
import use_case.jump_to_edit.JumpToEditInteractor;
import use_case.jump_to_edit.JumpToEditOutputBoundary;
import use_case.show_daily_special.ShowDailySpecialInputBoundary;
import use_case.show_daily_special.ShowDailySpecialInteractor;
import use_case.show_daily_special.ShowDailySpecialOutputBoundary;

import view.ReadRecipeView;

import data_access.FileRecipeDataAccessObject;

public class ReadRecipeViewUseCaseFactory extends UseCaseFactory {
    public static ReadRecipeView create(BackViewModel backViewModel,
                                        ViewManagerModel viewManagerModel,
                                        CreateRecipeViewModel createRecipeViewModel,
                                        ViewRecipeViewModel viewRecipeViewModel,
                                        AddToFavoritesViewModel addToFavoritesViewModel,
                                        CookedViewModel cookedViewModel,
                                        JumpToEditViewModel jumpToEditViewModel,
                                        ShowDailySpecialViewModel showDailySpecialViewModel,
                                        EditRecipeViewModel editRecipeViewModel,
                                        FileRecipeDataAccessObject DAO) {
        BackController backController = createBackController(backViewModel, viewManagerModel,DAO);
        AddToFavoritesController addToFavoritesController = createAddToFavoritesController(addToFavoritesViewModel, viewManagerModel, DAO);
        CookedController cookedController = createCookedController(cookedViewModel, viewManagerModel, DAO);
        JumpToEditController jumpToEditController = createJumpToEditController(viewManagerModel, jumpToEditViewModel, DAO);
        ShowDailySpecialController showDailySpecialController = createShowDailySpecialController(viewManagerModel, showDailySpecialViewModel, DAO);
        return new ReadRecipeView(backViewModel, backController,viewRecipeViewModel, createRecipeViewModel, addToFavoritesController, addToFavoritesViewModel, jumpToEditController, jumpToEditViewModel, cookedViewModel, cookedController,editRecipeViewModel,showDailySpecialViewModel, showDailySpecialController);
    }

    private static JumpToEditController createJumpToEditController(ViewManagerModel viewManagerModel,
                                                                   JumpToEditViewModel jumpToEditViewModel,
                                                                   FileRecipeDataAccessObject DAO) {
        JumpToEditOutputBoundary jumpToEditOutputBoundary = new JumpToEditPresenter(jumpToEditViewModel, viewManagerModel);
        JumpToEditInputBoundary jumpToEditInputBoundary = new JumpToEditInteractor(DAO, jumpToEditOutputBoundary);
        return new JumpToEditController(jumpToEditInputBoundary);
    }

    private static CookedController createCookedController(CookedViewModel cookedViewModel,
                                                           ViewManagerModel viewManagerModel,
                                                           FileRecipeDataAccessObject DAO) {
        CookedOutputBoundary cookedOutputBoundary = new CookedPresenter(cookedViewModel, viewManagerModel);
        CookedInputBoundary cookedInputBoundary = new use_case.cooked.CookedInteractor(DAO, cookedOutputBoundary);
        return new CookedController(cookedInputBoundary);
    }

    private static AddToFavoritesController createAddToFavoritesController(AddToFavoritesViewModel addToFavoritesViewModel,
                                                                           ViewManagerModel viewManagerModel,
                                                                           FileRecipeDataAccessObject DAO) {
        AddToFavoritesOutputBoundary addToFavoritesOutputBoundary = new AddToFavoritesPresenter(addToFavoritesViewModel, viewManagerModel);
        AddToFavoritesInputBoundary addToFavoritesInputBoundary = new AddToFavoritesInteractor(DAO, addToFavoritesOutputBoundary);
        return new AddToFavoritesController(addToFavoritesInputBoundary);
    }

    private static ShowDailySpecialController createShowDailySpecialController(ViewManagerModel viewManagerModel,
                                                                               ShowDailySpecialViewModel showDailySpecialViewModel,
                                                                               FileRecipeDataAccessObject DAO) {
        ShowDailySpecialOutputBoundary showDailySpecialOutputBoundary = new ShowDailySpecialPresenter(showDailySpecialViewModel,viewManagerModel);
        ShowDailySpecialInputBoundary showDailySpecialInputBoundary = new ShowDailySpecialInteractor(showDailySpecialOutputBoundary, DAO);
        return new ShowDailySpecialController(showDailySpecialInputBoundary);
    }

    public static BackController createBackController(BackViewModel backViewModel,
                                                      ViewManagerModel viewManagerModel,
                                                      FileRecipeDataAccessObject DAO) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary,DAO);
        return new BackController(backInputBoundary);
    }
}
