package app;

import data_access.FileRecipeDataAccessObject;
import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.view_recipe.ViewRecipeController;
import interface_adapter.view_recipe.ViewRecipePresenter;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import interface_adapter.view_search.ViewSearchController;
import interface_adapter.view_search.ViewSearchViewModel;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import use_case.view_recipe.ViewRecipeInputBoundary;
import use_case.view_recipe.ViewRecipeInteractor;
import use_case.view_recipe.ViewRecipeOutputBoundary;
import use_case.view_search.ViewSearchOutputBoundary;
import view.SearchView;

import static app.MainViewUseCaseFactory.createViewSearchController;

public class ViewSearchUseCaseFactory {

//    public static WarehouseView create(ViewRecipeViewModel viewRecipeViewModel, ViewWarehouseViewModel viewWarehouseViewModel, ViewManagerModel viewManagerModel, FileRecipeDataAccessObject dao, BackViewModel backViewModel) {
//        ViewRecipeController viewRecipeController1 = createViewRecipeController(viewRecipeViewModel, viewManagerModel, dao);
//        BackController backController = createBackController(backViewModel, viewManagerModel);
//        return new WarehouseView(viewRecipeController1, viewRecipeViewModel, backController,viewWarehouseViewModel,viewManagerModel);
//    }
    public static SearchView create(ViewSearchViewModel viewSearchViewModel, ViewManagerModel viewManagerModel, FileRecipeDataAccessObject dao, BackViewModel backViewModel){
        ViewSearchController viewSearchController = createViewSearchController(viewManagerModel, viewSearchViewModel, dao);
        BackController backController = createBackController(backViewModel, viewManagerModel);
        return new SearchView();
    }


    private static BackController createBackController(BackViewModel backViewModel, ViewManagerModel viewManagerModel) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary);
        return new BackController(backInputBoundary);
    }

}
