package interface_adapter.create_recipe;

import interface_adapter.ViewManagerModel;
import use_case.create_recipe.CreateRecipeOutputData;
import view.ReadRecipeView;
import view.ViewManager;

public class CreateRecipePresenter {
    private final CreateRecipeViewModel viewModel;
    private final ReadRecipeView view;
    private final ViewManagerModel viewManagerModel;
    public CreateRecipePresenter(CreateRecipeViewModel viewModel, ReadRecipeView view, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.view = view;
        this.viewManagerModel = viewManagerModel;
    }
    public void prepareSucessView(CreateRecipeOutputData response) {

    }
    public void prepareFailView(String error) {
    }
}
