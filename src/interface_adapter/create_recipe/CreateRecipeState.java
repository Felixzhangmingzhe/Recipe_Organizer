package interface_adapter.create_recipe;

import java.time.LocalDateTime;

public class CreateRecipeState {
    private String recipeName = "";
    private String recipeNameError = null;
    private String content = "";
    private String contentError = null;
    private LocalDateTime createdAt = null;
    private String createdAtError = null;
    private double calories;
    private String caloriesError = null;

    public CreateRecipeState(CreateRecipeState copy) {
        recipeName = copy.recipeName;
        recipeNameError = copy.recipeNameError;
        content = copy.content;
        contentError = copy.contentError;
    }
    public CreateRecipeState() {
    }
    public String getRecipeName() {
        return recipeName;
    }
    public String getRecipeNameError() {
        return recipeNameError;
    }
    public String getContent() {
        return content;
    }
    public String getContentError() {
        return contentError;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public String getCreatedAtError() {
        return createdAtError;
    }
    public double getCalories() {
        return calories;
    }
    public String getCaloriesError() {
        return caloriesError;
    }







    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    public void setRecipeNameError(String recipeNameError) {
        this.recipeNameError = recipeNameError;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setContentError(String contentError) {
        this.contentError = contentError;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setCreatedAtError(String createdAtError) {
        this.createdAtError = createdAtError;
    }
    public void setCalories(double calories) {
        this.calories = calories;
    }
    public void setCaloriesError(String caloriesError) {
        this.caloriesError = caloriesError;
    }

}
