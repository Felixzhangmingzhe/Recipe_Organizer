package interface_adapter.create_recipe;

import use_case.create_recipe.CreateRecipeOutputBoundary;
import use_case.create_recipe.CreateRecipeOutputData;
import view.RecipeView;

public class CreateRecipePresenter {
    private final CreateRecipeViewModel viewModel;
    private final RecipeView view;
    public CreateRecipePresenter(CreateRecipeViewModel viewModel, RecipeView view) {
        this.viewModel = viewModel;
        this.view = view;
    }
    public void prepareSucessView(CreateRecipeOutputData response) {
        // On success, switch to the clear view.
        // Give response to the view model
    }
    public void prepareFailView(String error) {
    }
}
