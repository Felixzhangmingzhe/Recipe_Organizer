package use_case.edit_recipe;

import entity.Recipe;

import java.time.LocalDateTime;

public interface EditRecipeDataAccessInterface {

        Recipe getRecipeByTitle(String title);
        void updateRecipe(int id, String title, Object content, LocalDateTime date, boolean isFavorite, boolean isCooked, double calories);
}
