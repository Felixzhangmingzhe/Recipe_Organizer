package interface_adapter.delete_recipe_from_favorites;

import use_case.delete_recipe_from_favorites.*;

public class DeleteRecipeFromFavoritesController {
    private final DeleteRecipeFromFavoritesInputBoundary interactor;

    public DeleteRecipeFromFavoritesController(DeleteRecipeFromFavoritesInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String recipeId) {
        DeleteRecipeFromFavoritesInputData inputData = new DeleteRecipeFromFavoritesInputData(recipeId);
        interactor.execute(inputData);
    }
}
