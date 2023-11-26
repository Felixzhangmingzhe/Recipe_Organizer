package use_case.view_recipe;

public class ViewRecipeInputData {
    private final String recipeId;

    public ViewRecipeInputData(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeId() {
        return recipeId;
    }
}
