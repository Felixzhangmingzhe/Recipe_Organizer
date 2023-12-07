package interface_adapter.jump_to_edit;

import entity.Recipe;

import java.time.LocalDateTime;

public class JumpToEditState {
    private String recipeTitle;
    private String recipeContent;
    private int recipeId;
    private boolean recipeIsFavorite;
    private double recipeCalories;
    private boolean recipeCooked;
    private LocalDateTime recipeCreationTime;


    public JumpToEditState() {
    }

    // 修改的复制构造函数
    public JumpToEditState(JumpToEditState copy) {
        this.recipeTitle = copy.recipeTitle;
        this.recipeContent = copy.recipeContent;
    }

    // Getters
    public String getRecipeTitle() {
        return recipeTitle;
    }

    public String getRecipeContent() {
        return recipeContent;
    }

    // Setters
    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public void setRecipeContent(String content) {
        this.recipeContent = content;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public void setRecipeIsFavorite(boolean recipeIsFavorite) {
        this.recipeIsFavorite = recipeIsFavorite;
    }

    public void setRecipeCalories(double recipeCalories) {
        this.recipeCalories = recipeCalories;
    }

    public void setRecipeCooked(boolean recipeCooked) {
        this.recipeCooked = recipeCooked;
    }
    public void setRecipeCreationTime(LocalDateTime recipeCreationTime) {
        this.recipeCreationTime = recipeCreationTime;
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
