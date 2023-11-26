package use_case.view_recipe;

import entity.Recipe;

import java.util.Map;

public interface ViewRecipeDataAccessInterface {
    public class InMemoryRecipeDataAccess implements ViewRecipeDataAccessInterface {
        private Map<String, Recipe> recipes;

        public InMemoryRecipeDataAccess(Map<String, Recipe> recipes) {
            this.recipes = recipes;
        }

        @Override
        public Recipe getRecipeById(String recipeId) {
            return recipes.get(recipeId);
        }
    }

}
