package entity;
import java.time.LocalDateTime;
public interface RecipeInterface {
    public int getId();
    public String getTitle();
    public String getContent();
    public LocalDateTime getDate();
}
