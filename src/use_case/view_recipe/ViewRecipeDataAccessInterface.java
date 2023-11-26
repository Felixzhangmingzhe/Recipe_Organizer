package use_case.view_recipe;

import entity.Recipe;

import java.util.Map;

public interface ViewRecipeDataAccessInterface {
    Recipe getRecipeById(String recipeId);
}
