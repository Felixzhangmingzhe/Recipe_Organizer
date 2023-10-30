package entity;
import java.time.LocalDateTime;
public class RecipeFactory {
    /**
     * Requires: password is valid.
     * @param id
     * @param title
     * @param content
     * @return
     */
    public Recipe create(int id, String title, String content, LocalDateTime date) {
        return new Recipe(id, title, content, date);
    }
}
