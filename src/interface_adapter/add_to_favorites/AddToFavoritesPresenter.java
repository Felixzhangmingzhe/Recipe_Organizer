package interface_adapter.add_to_favorites;

import use_case.add_to_favorites.*;

public class AddToFavoritesPresenter implements AddToFavoritesOutputBoundary {
    private final AddToFavoritesViewModel viewModel;

    public AddToFavoritesPresenter(AddToFavoritesViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void present(AddToFavoritesOutputData outputData) {

    }
}

