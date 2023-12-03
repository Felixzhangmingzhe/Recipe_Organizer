package use_case.jump_to_edit;

import entity.Recipe;
import java.time.LocalDateTime;

public interface JumpToEditDataAccessInterface {
    Recipe getRecipeByTitle(String title);
    void updateRecipe(int id, String title, String content, LocalDateTime date, boolean isFavorite, boolean isCooked, double calories);
}
