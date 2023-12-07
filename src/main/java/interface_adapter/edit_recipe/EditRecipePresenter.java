package interface_adapter.edit_recipe;

import interface_adapter.ViewManagerModel;
import use_case.edit_recipe.EditRecipeOutputBoundary;
import use_case.edit_recipe.EditRecipeOutputData;

public class EditRecipePresenter implements EditRecipeOutputBoundary {
    private final EditRecipeViewModel viewModel;
    private final ViewManagerModel viewManagerModel;

    public EditRecipePresenter(EditRecipeViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(EditRecipeOutputData outputData) {
        EditRecipeState state = viewModel.getState();
        state.setRecipeTitle(outputData.getRecipeTitle());
        state.setRecipeContent(outputData.getRecipeContent());
        state.setRecipeId(outputData.getRecipeId());
        state.setRecipeIsFavorite(outputData.getRecipeIsFavorite());
        state.setRecipeCalories(outputData.getRecipeCalories());
        state.setRecipeCooked(outputData.getRecipeCooked());
        state.setRecipeCreationTime(outputData.getRecipeCreationTime());

        viewModel.setState(state);
        viewModel.firePropertyChanged();
        viewManagerModel.setActiveView(viewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}