package interface_adapter.view_warehouse;

import interface_adapter.ViewManagerModel;
import use_case.view_warehouse.ViewWarehouseOutputData;

public class ViewWarehousePresenter {
    private final ViewWarehouseViewModel viewWarehouseViewModel;
    private ViewManagerModel viewManagerModel;

    public ViewWarehousePresenter(ViewWarehouseViewModel viewWarehouseViewModel, ViewManagerModel viewManagerModel) {
        this.viewWarehouseViewModel = viewWarehouseViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccess(ViewWarehouseOutputData viewWarehouseOutputData) {
        ViewWarehouseState viewWarehouseState = viewWarehouseViewModel.getState();
        viewWarehouseState.setRecipes(viewWarehouseOutputData.getRecipes());
        viewWarehouseViewModel.setState(viewWarehouseState);
        viewWarehouseViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(viewWarehouseViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
