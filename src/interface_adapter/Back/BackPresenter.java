package interface_adapter.Back;

import interface_adapter.ViewManagerModel;
import use_case.Back.BackOutputBoundary;

public class BackPresenter implements BackOutputBoundary {
    final BackViewModel viewModel;
    final ViewManagerModel viewManagerModel;

    public BackPresenter(ViewManagerModel viewManagerModel, BackViewModel viewModel) {
        this.viewManagerModel = viewManagerModel;
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView() {
        viewModel.firePropertyChanged();
        viewManagerModel.setActiveView(viewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
