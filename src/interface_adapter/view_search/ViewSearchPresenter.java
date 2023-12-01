package interface_adapter.view_search;

import interface_adapter.ViewManagerModel;
import interface_adapter.view_warehouse.ViewWarehouseState;
import use_case.view_search.ViewSearchOutputBoundary;
import use_case.view_warehouse.ViewWarehouseOutputData;

public class ViewSearchPresenter implements ViewSearchOutputBoundary {

    private final ViewSearchViewModel viewSearchViewModel;
    private ViewManagerModel viewManagerModel;

    public ViewSearchPresenter(ViewSearchViewModel viewSearchViewModel, ViewManagerModel viewManagerModel) {
        this.viewSearchViewModel = viewSearchViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessView() {
        //
        viewSearchViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(viewSearchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
