package use_case.edit_recipe;

public class EditRecipeInputData {
    private final String recipeId;
    private final String updatedRecipeDetails;

    public EditRecipeInputData(String recipeId, String updatedRecipeDetails) {
        this.recipeId = recipeId;
        this.updatedRecipeDetails = updatedRecipeDetails;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public String getUpdatedRecipeDetails() {
        return updatedRecipeDetails;
    }
}
