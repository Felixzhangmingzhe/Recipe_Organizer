package use_case.create_recipe;

import java.time.LocalDateTime;

public class CreateRecipeOutputData {
    private final int id;
    private final String title;
    private final String content;
    private final boolean isFavorite;
    private final double calories;
    private final LocalDateTime createdAt;
    public CreateRecipeOutputData(int id, String title, String content, boolean isFavorite, double calories, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isFavorite = isFavorite;
        this.calories = calories;
        this.createdAt = createdAt;

    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public boolean getisFavorite() {
        return isFavorite;
    }
    public double getCalories() {
        return calories;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
