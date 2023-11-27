package use_case.view_recipe;

public class ViewRecipeInputData {
    private final int recipeId;

    public ViewRecipeInputData(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getRecipeId() {
        return recipeId;
    }

}
