package interface_adapter.delete_recipe_from_favorites;

import use_case.delete_recipe_from_favorites.*;

public class DeleteRecipeFromFavoritesPresenter implements DeleteRecipeFromFavoritesOutputBoundary {
    private final DeleteRecipeFromFavoritesViewModel viewModel;

    public DeleteRecipeFromFavoritesPresenter(DeleteRecipeFromFavoritesViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void present(DeleteRecipeFromFavoritesOutputData outputData) {

    }
}
