package interface_adapter.view_warehouse;

import interface_adapter.ViewManagerModel;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import use_case.view_warehouse.ViewWarehouseOutputBoundary;
import use_case.view_warehouse.ViewWarehouseOutputData;
import view.WarehouseView;

public class ViewWarehousePresenter implements ViewWarehouseOutputBoundary {
    private final ViewWarehouseViewModel viewWarehouseViewModel;
    private final ViewRecipeViewModel viewRecipeViewModel;
    private ViewManagerModel viewManagerModel;


    public ViewWarehousePresenter(ViewWarehouseViewModel viewWarehouseViewModel, ViewRecipeViewModel viewRecipeViewModel, ViewManagerModel viewManagerModel) {
        this.viewWarehouseViewModel = viewWarehouseViewModel;
        this.viewRecipeViewModel = viewRecipeViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessView(ViewWarehouseOutputData viewWarehouseOutputData) {
        ViewWarehouseState viewWarehouseState = viewWarehouseViewModel.getState();
        viewWarehouseState.setRecipes(viewWarehouseOutputData.getRecipes());
        viewWarehouseViewModel.setState(viewWarehouseState);
        viewWarehouseViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(viewWarehouseViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        // 创建并登陆新的视图？
    }

}