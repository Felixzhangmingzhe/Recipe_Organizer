package interface_adapter.edit_recipe;

import use_case.edit_recipe.*;

public class EditRecipePresenter implements EditRecipeOutputBoundary {
    private final EditRecipeViewModel viewModel;

    public EditRecipePresenter(EditRecipeViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void present(EditRecipeOutputData outputData) {

    }
}
