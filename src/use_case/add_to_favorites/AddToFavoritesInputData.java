package use_case.add_to_favorites;

public class AddToFavoritesInputData {
    private final String recipeId;

    public AddToFavoritesInputData(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeId() {
        return recipeId;
    }
}
