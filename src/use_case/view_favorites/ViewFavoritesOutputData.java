package use_case.view_favorites;

import entity.Recipe;

import java.util.List;

public class ViewFavoritesOutputData {
    private final List<Recipe> recipes;

    public ViewFavoritesOutputData(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
