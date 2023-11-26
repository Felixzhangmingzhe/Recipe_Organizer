package use_case.delete_recipe_from_favorites;

public class DeleteRecipeFromFavoritesOutputData {
    private final boolean success;
    private final String message;

    public DeleteRecipeFromFavoritesOutputData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
