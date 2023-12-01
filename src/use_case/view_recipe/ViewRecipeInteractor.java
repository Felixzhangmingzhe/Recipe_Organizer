package use_case.view_recipe;

import entity.Recipe;

public class ViewRecipeInteractor implements ViewRecipeInputBoundary {
    private final ViewRecipeDataAccessInterface dataAccess;
    private final ViewRecipeOutputBoundary viewRecipePresenter;

    public ViewRecipeInteractor(ViewRecipeDataAccessInterface dataAccess, ViewRecipeOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.viewRecipePresenter = outputBoundary;
    }

    @Override
    public void viewRecipe(ViewRecipeInputData inputData) {
        Recipe recipe = dataAccess.getRecipeByTitle(inputData.getTitle());
        if (recipe != null) {
            ViewRecipeOutputData outputData = new ViewRecipeOutputData(recipe.getTitle(), recipe.getContent(), recipe.getDate(), recipe.getCalories());
            viewRecipePresenter.prepareSuccessView(outputData);
        } else {
            viewRecipePresenter.prepareFailView("Recipe not found.");
        }
    }

}