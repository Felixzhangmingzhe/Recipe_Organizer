package app;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.view_search.ViewSearchController;
import interface_adapter.view_search.ViewSearchPresenter;
import interface_adapter.view_search.ViewSearchViewModel;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import use_case.view_search.ViewSearchInputBoundary;
import use_case.view_search.ViewSearchInteractor;
import view.SearchView;
import view.SearchView1;

public class ViewSearchUseCaseFactory {

//    public static WarehouseView create(ViewRecipeViewModel viewRecipeViewModel, ViewWarehouseViewModel viewWarehouseViewModel, ViewManagerModel viewManagerModel, FileRecipeDataAccessObject dao, BackViewModel backViewModel) {
//        ViewRecipeController viewRecipeController1 = createViewRecipeController(viewRecipeViewModel, viewManagerModel, dao);
//        BackController backController = createBackController(backViewModel, viewManagerModel);
//        return new WarehouseView(viewRecipeController1, viewRecipeViewModel, backController,viewWarehouseViewModel,viewManagerModel);
//    }
    public static SearchView create(ViewSearchViewModel viewSearchViewModel, ViewManagerModel viewManagerModel, BackViewModel backViewModel){
        ViewSearchController viewSearchController = createViewSearchController(viewManagerModel, viewSearchViewModel);
        BackController backController = createBackController(backViewModel, viewManagerModel);
        return new SearchView(backController, backViewModel, viewSearchController, viewSearchViewModel);
    }

    private static ViewSearchController createViewSearchController(ViewManagerModel viewManagerModel, ViewSearchViewModel viewSearchViewModel) {
        ViewSearchPresenter viewSearchOutputBoundary = new ViewSearchPresenter(viewSearchViewModel, viewManagerModel);
        ViewSearchInputBoundary viewSearchInputBoundary = new ViewSearchInteractor(viewSearchOutputBoundary);
        return new ViewSearchController(viewSearchInputBoundary);
    }


    private static BackController createBackController(BackViewModel backViewModel, ViewManagerModel viewManagerModel) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary);
        return new BackController(backInputBoundary);
    }

}
