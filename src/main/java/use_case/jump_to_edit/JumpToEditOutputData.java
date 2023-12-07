package use_case.jump_to_edit;

import java.time.LocalDateTime;

public class JumpToEditOutputData {
    private final String recipeTitle;
    private final String recipeContent;
    private final int recipeId;
    private final boolean recipeIsFavorite;
    private final double recipeCalories;
    private final boolean recipeCooked;

    private final LocalDateTime recipeCreationTime;


    public JumpToEditOutputData(String recipeTitle, String recipeContent, int recipeId, boolean recipeIsFavorite, double recipeCalories, boolean recipeCooked, LocalDateTime recipeCreationTime) {
        this.recipeTitle = recipeTitle;
        this.recipeContent = recipeContent;
        this.recipeId = recipeId;
        this.recipeIsFavorite = recipeIsFavorite;
        this.recipeCalories = recipeCalories;
        this.recipeCooked = recipeCooked;
        this.recipeCreationTime = recipeCreationTime;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public String getRecipeContent() {
        return recipeContent;
    }
    public int getRecipeId() {
        return recipeId;
    }
    public boolean getRecipeIsFavorite() {
        return recipeIsFavorite;
    }
    public double getRecipeCalories() {
        return recipeCalories;
    }
    public boolean getRecipeCooked() {
        return recipeCooked;
    }
    public LocalDateTime getRecipeCreationTime() {
        return recipeCreationTime;
    }
}
