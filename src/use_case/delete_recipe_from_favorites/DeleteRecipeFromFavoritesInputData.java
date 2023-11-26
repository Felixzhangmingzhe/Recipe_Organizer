package use_case.delete_recipe_from_favorites;

public class DeleteRecipeFromFavoritesInputData {
    private final String recipeId;

    public DeleteRecipeFromFavoritesInputData(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeId() {
        return recipeId;
    }
}
