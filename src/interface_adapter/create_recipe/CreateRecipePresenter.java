package interface_adapter.create_recipe;

import use_case.create_recipe.CreateRecipeOutputBoundary;
import use_case.create_recipe.CreateRecipeOutputData;

public class CreateRecipePresenter {
    private final CreateRecipeViewModel viewModel;
    private final CreateRecipeView view;
    public CreateRecipePresenter(CreateRecipeViewModel viewModel, CreateRecipeView view) {
        this.viewModel = viewModel;
        this.view = view;
    }
    public void prepareSucessView(CreateRecipeOutputData response) {
        // On success, switch to the clear view.
        // Give response to the view model
        CreateRecipeState state = viewModel.getState();
        state.setRecipeName(response.getRecipeName());
        state.setRecipeDescription(response.getRecipeDescription());
        state.setRecipeIngredients(response.getRecipeIngredients());
        state.setRecipeInstructions(response.getRecipeInstructions());
        viewModel.setState(state);
        viewModel.firePropertyChanged();
        view.setRecipeName(state.getRecipeName());
        view.setRecipeDescription(state.getRecipeDescription());
        view.setRecipeIngredients(state.getRecipeIngredients());
        view.setRecipeInstructions(state.getRecipeInstructions());
    }
    public void prepareFailView(String error) {
        CreateRecipeState state = viewModel.getState();
        viewModel.firePropertyChanged();
    }
}
