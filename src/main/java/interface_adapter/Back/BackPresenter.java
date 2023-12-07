package interface_adapter.Back;

import interface_adapter.ViewManagerModel;
import use_case.Back.BackOutputBoundary;
import use_case.Back.BackOutputData;

public class BackPresenter implements BackOutputBoundary {
    final BackViewModel viewModel;
    final ViewManagerModel viewManagerModel;

    public BackPresenter(ViewManagerModel viewManagerModel, BackViewModel viewModel) {
        this.viewManagerModel = viewManagerModel;
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(BackOutputData response) {
        BackState state = viewModel.getState();
        state.setNumOfCooked(response.getNumOfCooked());
        viewModel.setState(state);
        viewModel.firePropertyChanged();
        viewManagerModel.setActiveView(viewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
