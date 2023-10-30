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
    }
    public void prepareFailView(String error) {

    }
}
