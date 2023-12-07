package use_case.add_to_favorites;

import entity.Recipe;
import org.json.JSONException;

import java.time.LocalDateTime;

public interface AddToFavoritesDataAccessInterface {

    Recipe getRecipeByTitle(String title);

    void updateRecipe(int id, String title, String content, LocalDateTime date, boolean isFavorite, boolean isCooked, double calories);
}
