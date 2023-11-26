package use_case.view_recipe;

import entity.Recipe;

public class ViewRecipeInteractor implements ViewRecipeInputBoundary {
    private final ViewRecipeDataAccessInterface dataAccess;
    private final ViewRecipeOutputBoundary outputBoundary;

    public ViewRecipeInteractor(ViewRecipeDataAccessInterface dataAccess, ViewRecipeOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void viewRecipe(ViewRecipeInputData inputData) {
        Recipe recipe = dataAccess.getRecipeById(inputData.getRecipeId());
        if (recipe != null) {
            ViewRecipeOutputData outputData = new ViewRecipeOutputData(recipe);
            outputBoundary.presentRecipe(outputData);
        } else {
            // Handle the case where the recipe is not found
            // This could involve calling another method on the outputBoundary to present an error
        }
    }

}