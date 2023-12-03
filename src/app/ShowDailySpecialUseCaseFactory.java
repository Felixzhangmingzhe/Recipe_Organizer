package app;

import data_access.FileRecipeDataAccessObject;
import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.show_daily_special.ShowDailySpecialViewModel;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import use_case.Back.BackDataAccessInterface;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import view.DailySpecialView;

public class ShowDailySpecialUseCaseFactory extends UseCaseFactory{

    public static DailySpecialView create(BackViewModel backViewModel, ViewManagerModel viewManagerModel,
                                          ShowDailySpecialViewModel showDailySpecialViewModel,
                                          ViewRecipeViewModel viewRecipeViewModel,
                                          FileRecipeDataAccessObject dao) {
        BackController backController = createBackController(backViewModel, viewManagerModel,dao);

        return new DailySpecialView(backViewModel, backController,viewRecipeViewModel, showDailySpecialViewModel);
    }
    public static BackController createBackController(BackViewModel backViewModel, ViewManagerModel viewManagerModel, BackDataAccessInterface dao) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary,dao);
        return new BackController(backInputBoundary);
    }

}
