package use_case.view_recipe;

import entity.Recipe;

public class ViewRecipeOutputData {
    private final Recipe recipe;

    public ViewRecipeOutputData(Recipe recipe) {
        this.recipe = recipe;
    }

    public Recipe getRecipe() {
        return recipe;
    }
}