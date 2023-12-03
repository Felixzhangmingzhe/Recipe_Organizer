package interface_adapter.jump_to_edit;

import interface_adapter.ViewManagerModel;
import use_case.jump_to_edit.*;

public class JumpToEditPresenter implements JumpToEditOutputBoundary {
    private final JumpToEditViewModel viewModel;
    private final ViewManagerModel viewManagerModel;

    public JumpToEditPresenter(JumpToEditViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(JumpToEditOutputData outputData) {
        JumpToEditState state = viewModel.getState();
        state.setRecipeTitle(outputData.getRecipeTitle());
        state.setRecipeContent(outputData.getRecipeContent());
        viewModel.setState(state);
        viewModel.firePropertyChanged();
        viewManagerModel.setActiveView(viewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
