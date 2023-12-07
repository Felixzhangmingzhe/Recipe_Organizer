package app;

import data_access.FileRecipeDataAccessObject;
import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.click_search.ClickSearchController;
import interface_adapter.click_search.ClickSearchPresenter;
import interface_adapter.click_search.ClickSearchViewModel;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import use_case.click_search.ClickSearchInputBoundary;
import use_case.click_search.ClickSearchInteractor;
import view.SearchNewView;

public class SearchNewViewUseCaseFactory {

    public SearchNewView create() {
        return new SearchNewView();
    }

    private static BackController createBackController(BackViewModel backViewModel, ViewManagerModel viewManagerModel,FileRecipeDataAccessObject dao) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary,dao);
        return new BackController(backInputBoundary);
    }

    private static ClickSearchController createClickSearchController(ClickSearchViewModel clickSearchViewModel, ViewManagerModel viewManagerModel, FileRecipeDataAccessObject dao) {
        ClickSearchPresenter clickSearchOutputBoundary = new ClickSearchPresenter(clickSearchViewModel, viewManagerModel);
        ClickSearchInputBoundary clickSearchInputBoundary = new ClickSearchInteractor(dao, clickSearchOutputBoundary);
        return new ClickSearchController(clickSearchInputBoundary);
    }

}
