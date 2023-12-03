package interface_adapter.edit_recipe;

import java.time.LocalDateTime;

public class EditRecipeState {
    private String recipeTitle;
    private String recipeContent;
    
    private int recipeId;
    private boolean recipeIsFavorite;
    private double recipeCalories;
    private boolean recipeCooked;
    private LocalDateTime recipeCreationTime;

    public EditRecipeState(EditRecipeState state) {
        this.recipeTitle = state.recipeTitle;
        this.recipeContent = state.recipeContent;
    }
    public EditRecipeState() {
    }
    public String getRecipeTitle() {
        return recipeTitle;
    }
    public String getRecipeContent() {
        return recipeContent;
    }
    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }
    public void setRecipeContent(String recipeContent) {
        this.recipeContent = recipeContent;
    }
    public int getRecipeId() {
        return recipeId;
    }
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
    public boolean getRecipeIsFavorite() {
        return recipeIsFavorite;
    }
    public void setRecipeIsFavorite(boolean recipeIsFavorite) {
        this.recipeIsFavorite = recipeIsFavorite;
    }
    public double getRecipeCalories() {
        return recipeCalories;
    }
    public void setRecipeCalories(double recipeCalories) {
        this.recipeCalories = recipeCalories;
    }
    public boolean getRecipeCooked() {
        return recipeCooked;
    }
    public void setRecipeCooked(boolean recipeCooked) {
        this.recipeCooked = recipeCooked;
    }
    public LocalDateTime getRecipeCreationTime() {
        return recipeCreationTime;
    }
    public void setRecipeCreationTime(LocalDateTime recipeCreationTime) {
        this.recipeCreationTime = recipeCreationTime;
    }

}
