package app;

import data_access.FileRecipeDataAccessObject;
import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.show_daily_special.ShowDailySpecialViewModel;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import view.DailySpecialView;

public class ShowDailySpecialUseCaseFactory extends UseCaseFactory{

//    public static ShowDailySpecialController create(ShowDailySpecialViewModel showDailySpecialViewModel,
//                                                    ShowDailySpecialOutputBoundary showDailySpecialOutputBoundary,
//                                                    FileRecipeDataAccessObject dao) {
//        ShowDailySpecialInputBoundary showDailySpecialInputBoundary = new ShowDailySpecialInteractor(showDailySpecialOutputBoundary, dao);
//        return new ShowDailySpecialController(showDailySpecialInputBoundary);
//    }


//    public static ReadRecipeView create(BackViewModel backViewModel, ViewManagerModel viewManagerModel,
//                                        ShowDailySpecialViewModel showDailySpecialViewModel,
//                                        ViewRecipeViewModel viewRecipeViewModel,
//                                        CreateRecipeViewModel createRecipeViewModel,
//                                        FileRecipeDataAccessObject dao) {
//        BackController backController = createBackController(backViewModel, viewManagerModel);
//
//        return new ReadRecipeView(backViewModel, backController,viewRecipeViewModel,createRecipeViewModel, showDailySpecialViewModel);
//    }
    //不用你了

    public static DailySpecialView create(BackViewModel backViewModel, ViewManagerModel viewManagerModel,
                                          ShowDailySpecialViewModel showDailySpecialViewModel,
                                          ViewRecipeViewModel viewRecipeViewModel,
                                          FileRecipeDataAccessObject dao) {
        BackController backController = createBackController(backViewModel, viewManagerModel);

        return new DailySpecialView(backViewModel, backController,viewRecipeViewModel, showDailySpecialViewModel);
    }
    public static BackController createBackController(BackViewModel backViewModel, ViewManagerModel viewManagerModel) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary);
        return new BackController(backInputBoundary);
    }

}
