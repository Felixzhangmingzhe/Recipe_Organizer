package app;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.click_search.ClickSearchController;
import interface_adapter.click_search.ClickSearchPresenter;
import interface_adapter.click_search.ClickSearchViewModel;
import interface_adapter.view_search.ViewSearchController;
import interface_adapter.view_search.ViewSearchViewModel;
import interface_adapter.ViewManagerModel;

import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import use_case.click_search.ClickSearchInputBoundary;
import use_case.click_search.ClickSearchInteractor;

import view.SearchView;

import data_access.FileRecipeDataAccessObject;

import static app.MainViewUseCaseFactory.createViewSearchController;

public class ViewSearchUseCaseFactory extends UseCaseFactory{

    public static SearchView create(ViewSearchViewModel viewSearchViewModel,
                                    ViewManagerModel viewManagerModel,
                                    BackViewModel backViewModel,
                                    ClickSearchViewModel clickSearchViewModel,
                                    FileRecipeDataAccessObject DAO){
        ViewSearchController viewSearchController = createViewSearchController(viewManagerModel, viewSearchViewModel);
        BackController backController = createBackController(backViewModel, viewManagerModel,DAO);
        ClickSearchController clickSearchController = createClickSearchController(clickSearchViewModel, viewManagerModel, DAO);
        return new SearchView(backController, backViewModel, viewSearchController, viewSearchViewModel, clickSearchController, clickSearchViewModel);
    }

    private static BackController createBackController(BackViewModel backViewModel,
                                                       ViewManagerModel viewManagerModel,
                                                       FileRecipeDataAccessObject DAO) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary, DAO);
        return new BackController(backInputBoundary);
    }

    private static ClickSearchController createClickSearchController(ClickSearchViewModel clickSearchViewModel,
                                                                     ViewManagerModel viewManagerModel,
                                                                     FileRecipeDataAccessObject DAO) {
        ClickSearchPresenter clickSearchOutputBoundary = new ClickSearchPresenter(clickSearchViewModel, viewManagerModel);
        ClickSearchInputBoundary clickSearchInputBoundary = new ClickSearchInteractor(DAO, clickSearchOutputBoundary);
        return new ClickSearchController(clickSearchInputBoundary);
    }
}
