package use_case.edit_recipe;

import java.time.LocalDateTime;

public class EditRecipeOutputData {
    private String recipeTitle;
    private String recipeContent;
    private int recipeId;

    private boolean recipeIsFavorite;
    private double recipeCalories;
    private boolean recipeCooked;
    private LocalDateTime recipeCreationTime;

    public EditRecipeOutputData(String recipeTitle, String recipeContent, int recipeId, boolean recipeIsFavorite, double recipeCalories, boolean recipeCooked, LocalDateTime recipeCreationTime) {
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
