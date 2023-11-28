package app;

import data_access.FileRecipeDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.view_recipe.ViewRecipeController;
import interface_adapter.view_recipe.ViewRecipePresenter;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import use_case.view_recipe.ViewRecipeInputBoundary;
import use_case.view_recipe.ViewRecipeInteractor;
import use_case.view_recipe.ViewRecipeOutputBoundary;
import use_case.view_warehouse.ViewWarehouseInputBoundary;
import use_case.view_warehouse.ViewWarehouseInteractor;
import view.WarehouseView;

public class WarehouseViewUseCaseFactory {
    public static WarehouseView create(ViewRecipeViewModel viewRecipeViewModel, ViewManagerModel viewManagerModel, FileRecipeDataAccessObject dao) {
        ViewRecipeController viewRecipeController1 = createViewRecipeController(viewRecipeViewModel, viewManagerModel, dao);
        return new WarehouseView(viewRecipeController1, viewRecipeViewModel, viewManagerModel);
    }

    private static ViewRecipeController createViewRecipeController(ViewRecipeViewModel viewRecipeViewModel, ViewManagerModel viewWarehouseViewModel, FileRecipeDataAccessObject dao) {
        ViewRecipeOutputBoundary viewRecipeOutputBoundary = new ViewRecipePresenter(viewRecipeViewModel, viewWarehouseViewModel);
        ViewRecipeInputBoundary viewRecipeInputBoundary = new ViewRecipeInteractor(dao, (ViewRecipePresenter) viewRecipeOutputBoundary);
        return new ViewRecipeController(viewRecipeInputBoundary);
    }
}
