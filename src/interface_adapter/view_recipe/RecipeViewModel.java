package interface_adapter.view_recipe;

import entity.Recipe;

public class RecipeViewModel {
    private final Recipe recipe;

    public RecipeViewModel(Recipe recipe) {
        this.recipe = recipe;
    }

}
