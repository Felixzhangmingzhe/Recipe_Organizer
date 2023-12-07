package use_case.edit_recipe;

import entity.Recipe;
import org.json.JSONException;

import java.time.LocalDateTime;

public interface EditRecipeDataAccessInterface {

        Recipe getRecipeByTitle(String title);
        void updateRecipe(int id, String title, Object content, LocalDateTime date, boolean isFavorite, boolean isCooked, double calories) throws JSONException;
}
