package app;

import data_access.FileRecipeDataAccessObject;
import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.click_search.ClickSearchController;
import interface_adapter.click_search.ClickSearchPresenter;
import interface_adapter.click_search.ClickSearchViewModel;
import interface_adapter.view_search.ViewSearchController;
import interface_adapter.view_search.ViewSearchPresenter;
import interface_adapter.view_search.ViewSearchViewModel;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import use_case.click_search.ClickSearchInputBoundary;
import use_case.click_search.ClickSearchInteractor;
import view.SearchView;

import static app.MainViewUseCaseFactory.createViewSearchController;

public class ViewSearchUseCaseFactory {
//    public static WarehouseView create(ViewRecipeViewModel viewRecipeViewModel, ViewWarehouseViewModel viewWarehouseViewModel, ViewManagerModel viewManagerModel, FileRecipeDataAccessObject dao, BackViewModel backViewModel) {
//        ViewRecipeController viewRecipeController1 = createViewRecipeController(viewRecipeViewModel, viewManagerModel, dao);
//        BackController backController = createBackController(backViewModel, viewManagerModel);
//        return new WarehouseView(viewRecipeController1, viewRecipeViewModel, backController,viewWarehouseViewModel,viewManagerModel);
//    }

    public static SearchView create(ViewSearchViewModel viewSearchViewModel, ViewManagerModel viewManagerModel, BackViewModel backViewModel, ClickSearchViewModel clickSearchViewModel, FileRecipeDataAccessObject dao){
        ViewSearchController viewSearchController = createViewSearchController(viewManagerModel, viewSearchViewModel);
        BackController backController = createBackController(backViewModel, viewManagerModel,dao);
        ClickSearchController clickSearchController = createClickSearchController(clickSearchViewModel, viewManagerModel, dao);
        return new SearchView(backController, backViewModel, viewSearchController, viewSearchViewModel, clickSearchController, clickSearchViewModel);
    }


    private static BackController createBackController(BackViewModel backViewModel, ViewManagerModel viewManagerModel,FileRecipeDataAccessObject dao) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary,dao);
        return new BackController(backInputBoundary);
    }

    private static ClickSearchController createClickSearchController(ClickSearchViewModel clickSearchViewModel, ViewManagerModel viewManagerModel, FileRecipeDataAccessObject dao) {
        ClickSearchPresenter clickSearchOutputBoundary = new ClickSearchPresenter(clickSearchViewModel, viewManagerModel);
        ClickSearchInputBoundary clickSearchInputBoundary = new ClickSearchInteractor(clickSearchOutputBoundary, dao);
        return new ClickSearchController(clickSearchInputBoundary);
    }
}
