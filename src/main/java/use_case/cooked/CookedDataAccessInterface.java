package use_case.cooked;

import entity.Recipe;
import org.json.JSONException;

import java.time.LocalDateTime;

public interface CookedDataAccessInterface {
    Recipe getRecipeByRecipeTitle(String recipeTitle);

    void updateCookedRecipe(int id, String title, String content, LocalDateTime date, boolean isFavorite, boolean isCooked, double calories) throws JSONException;
}
