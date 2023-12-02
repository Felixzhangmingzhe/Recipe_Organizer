package app;

import data_access.FileRecipeDataAccessObject;
import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.click_search.ClickSearchController;
import interface_adapter.click_search.ClickSearchPresenter;
import interface_adapter.click_search.ClickSearchViewModel;
import interface_adapter.view_recipe.ViewRecipeController;
import interface_adapter.view_recipe.ViewRecipePresenter;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import interface_adapter.view_search.ViewSearchController;
import interface_adapter.view_search.ViewSearchPresenter;
import interface_adapter.view_search.ViewSearchViewModel;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import use_case.click_search.ClickSearchInputBoundary;
import use_case.click_search.ClickSearchInteractor;
import use_case.view_recipe.ViewRecipeInputBoundary;
import use_case.view_recipe.ViewRecipeInteractor;
import use_case.view_recipe.ViewRecipeOutputBoundary;
import use_case.view_search.ViewSearchInputBoundary;
import use_case.view_search.ViewSearchInteractor;
import use_case.view_search.ViewSearchOutputBoundary;
import view.SearchView;

import static app.MainViewUseCaseFactory.createViewSearchController;

public class ViewSearchUseCaseFactory {

    public static SearchView create(ViewSearchViewModel viewSearchViewModel, ViewManagerModel viewManagerModel, BackViewModel backViewModel, ClickSearchViewModel clickSearchViewModel, FileRecipeDataAccessObject dao){
        ViewSearchController viewSearchController = createViewSearchController(viewManagerModel, viewSearchViewModel);
        BackController backController = createBackController(backViewModel, viewManagerModel);
        ClickSearchController clickSearchController = createClickSearchController(clickSearchViewModel, viewManagerModel, dao);
        return new SearchView(backController, backViewModel, viewSearchController, viewSearchViewModel, clickSearchController, clickSearchViewModel);
    }


    private static BackController createBackController(BackViewModel backViewModel, ViewManagerModel viewManagerModel) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary);
        return new BackController(backInputBoundary);
    }

    private static ClickSearchController createClickSearchController(ClickSearchViewModel clickSearchViewModel, ViewManagerModel viewManagerModel, FileRecipeDataAccessObject dao) {
        ClickSearchPresenter clickSearchOutputBoundary = new ClickSearchPresenter(clickSearchViewModel, viewManagerModel);
        ClickSearchInputBoundary clickSearchInputBoundary = new ClickSearchInteractor(clickSearchOutputBoundary, dao);
        return new ClickSearchController(clickSearchInputBoundary);
    }

}
