package interface_adapter.create_recipe;

import interface_adapter.ViewManagerModel;
import use_case.create_recipe.CreateRecipeOutputBoundary;
import use_case.create_recipe.CreateRecipeOutputData;
import view.ReadRecipeView;
import view.ViewManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateRecipePresenter implements CreateRecipeOutputBoundary {
    private final CreateRecipeViewModel viewModel;
    private final ViewManagerModel viewManagerModel;
    public CreateRecipePresenter(CreateRecipeViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView(CreateRecipeOutputData response) {
        // On success, switch to the login view.
        CreateRecipeState state = viewModel.getState();
        state.setRecipeName(response.getTitle());
        state.setContent(response.getContent());
        state.setCreationTime(response.getCreationTime());
        state.setCalories(response.getCalories());
        this.viewModel.setState(state);
        viewModel.firePropertyChanged();
        viewManagerModel.setActiveView(viewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
    @Override
    public void prepareFailView(String error) {
        CreateRecipeState state = viewModel.getState();
        state.setRecipeNameError(error);
        viewModel.firePropertyChanged();
    }
}
