package interface_adapter.create_recipe;

import use_case.create_recipe.CreateRecipeOutputData;
import view.ReadRecipeView;

public class CreateRecipePresenter {
    private final CreateRecipeViewModel viewModel;
    private final ReadRecipeView view;
    public CreateRecipePresenter(CreateRecipeViewModel viewModel, ReadRecipeView view) {
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
