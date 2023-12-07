package use_case.view_recipe;

import entity.Recipe;

public class ViewRecipeInteractor implements ViewRecipeInputBoundary {
    // Data access interface and presenter
    private final ViewRecipeDataAccessInterface viewRecipeDataAccessInterface;
    private final ViewRecipeOutputBoundary viewRecipePresenter;

    // Constructor
    public ViewRecipeInteractor(ViewRecipeDataAccessInterface dataAccess, ViewRecipeOutputBoundary outputBoundary) {
        this.viewRecipeDataAccessInterface = dataAccess;
        this.viewRecipePresenter = outputBoundary;
    }

    // Implementation of execute method in Input Boundary
    @Override
    public void viewRecipe(ViewRecipeInputData inputData) {
        // Retrieve recipe by title
        Recipe recipe = viewRecipeDataAccessInterface.getRecipeByTitle(inputData.getTitle());

        if (recipe != null) {
            // Output data indicating exist some recipes
            ViewRecipeOutputData outputData = new ViewRecipeOutputData(recipe.getTitle(), recipe.getContent(), recipe.getDate(), recipe.getCalories(),recipe.getIsFavorite(), recipe.getIsCooked());
            viewRecipePresenter.prepareSuccessView(outputData);
        } else {
            // No recipe found
            viewRecipePresenter.prepareFailView("Recipe not found.");
        }
    }

}