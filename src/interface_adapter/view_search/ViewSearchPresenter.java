package interface_adapter.view_search;

import interface_adapter.ViewManagerModel;
import use_case.view_search.ViewSearchOutputBoundary;

public class ViewSearchPresenter implements ViewSearchOutputBoundary {

    private ViewSearchViewModel viewSearchViewModel;
    private ViewManagerModel viewManagerModel;

    public ViewSearchPresenter(ViewSearchViewModel viewSearchViewModel, ViewManagerModel viewManagerModel) {
        this.viewSearchViewModel = viewSearchViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessView() {
        //
        viewSearchViewModel.firePropertyChanged();
        viewManagerModel.setActiveView("search");
        viewManagerModel.firePropertyChanged();
        // MainView 添加监听器，监听 viewManagerModel 的变化，变化后调用 viewManagerModel.getActiveView() 获取当前活跃的 view，然后根据 view 的名字显示对应的 view

    }
}
