package interface_adapter.add_to_favorites;

import interface_adapter.ViewManagerModel;
import use_case.add_to_favorites.AddToFavoritesOutputBoundary;
import use_case.add_to_favorites.AddToFavoritesOutputData;

public class AddToFavoritesPresenter implements AddToFavoritesOutputBoundary {
    private final AddToFavoritesViewModel viewModel;
    private final ViewManagerModel viewManagerModel;

    public AddToFavoritesPresenter(AddToFavoritesViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(AddToFavoritesOutputData outputData) {
        AddToFavoritesState state = viewModel.getState();
        state.setAddToFavoritesMessage(outputData.getAddToFavoritesMessage());
        state.setDeleteFromFavoritesMessage(outputData.getDeleteFromFavoritesMessage());
        viewModel.setState(state);
        viewModel.firePropertyChanged();
        viewManagerModel.setActiveView(viewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

