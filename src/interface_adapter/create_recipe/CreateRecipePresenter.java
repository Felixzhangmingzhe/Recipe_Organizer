package interface_adapter.create_recipe;

import interface_adapter.ViewManagerModel;
import use_case.create_recipe.CreateRecipeOutputData;
import view.ReadRecipeView;
import view.ViewManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateRecipePresenter {
    private final CreateRecipeViewModel viewModel;
    private final ViewManagerModel viewManagerModel;
    public CreateRecipePresenter(CreateRecipeViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
    }
    public void prepareSucessView(CreateRecipeOutputData response) {
        // On success, switch to the login view.
        CreateRecipeState state = viewModel.getState();
        state.setRecipeName(response.getTitle());
        state.setContent(response.getContent());
        this.viewModel.setState(state);// 等等，他在SignupPresenter里面，为什么要改LoginViewModel的state？
        viewModel.firePropertyChanged();

        viewManagerModel.setActiveView(viewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
    public void prepareFailView(String error) {
        CreateRecipeState state = viewModel.getState();
        state.setRecipeNameError(error);
        viewModel.firePropertyChanged();
    }
}
