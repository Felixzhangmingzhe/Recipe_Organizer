package interface_adapter.view_recipe;

import use_case.view_recipe.ViewRecipeInputBoundary;
import use_case.view_recipe.ViewRecipeInputData;

public class ViewRecipeController {
    private final ViewRecipeInputBoundary inputBoundary;

    public ViewRecipeController(ViewRecipeInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void execute(String recipeTitle) {
        ViewRecipeInputData inputData = new ViewRecipeInputData(recipeTitle);
        inputBoundary.viewRecipe(inputData);
    }


}
