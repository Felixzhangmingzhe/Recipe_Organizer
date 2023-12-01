package interface_adapter.create_recipe;

import interface_adapter.ViewManagerModel;
import use_case.create_recipe.CreateRecipeOutputBoundary;
import use_case.create_recipe.CreateRecipeOutputData;

public class CreateRecipePresenter implements CreateRecipeOutputBoundary {
    private final CreateRecipeViewModel createRecipeViewModel;
    private final ViewManagerModel viewManagerModel;
    public CreateRecipePresenter(CreateRecipeViewModel createRecipeViewModel, ViewManagerModel viewManagerModel) {
        this.createRecipeViewModel = createRecipeViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView(CreateRecipeOutputData response) {
        // On success, switch to the login view.
        CreateRecipeState state = createRecipeViewModel.getState();
        state.setRecipeName(response.getTitle());
        state.setContent(response.getContent());
        System.out.println(response.getContent());
        state.setCreatedAt(response.getCreatedAt());
        state.setCalories(response.getCalories());
        this.createRecipeViewModel.setState(state);
        createRecipeViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(createRecipeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();// this evt is state.
        System.out.println(state.getContent());

    }
    @Override
    public void prepareFailView(String error) {
        if (error.equals("Recipe already exists")) {
            CreateRecipeState state = createRecipeViewModel.getState();
            state.setConflictError("Recipe name already exists");
            createRecipeViewModel.firePropertyChanged();
        } else if (error.equals("Title is empty")) {
            CreateRecipeState state = createRecipeViewModel.getState();
            state.setRecipeNameError("Title is empty");
            createRecipeViewModel.firePropertyChanged();
        } else if (error.equals("Content is empty")) {
            CreateRecipeState state = createRecipeViewModel.getState();
            state.setContentError("Content is empty");
            createRecipeViewModel.firePropertyChanged();
        }
        System.out.println(error);
        createRecipeViewModel.firePropertyChanged();
    }
}
