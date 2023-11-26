package use_case.delete_recipe_from_favorites;

public class DeleteRecipeFromFavoritesInteractor implements DeleteRecipeFromFavoritesInputBoundary {
    private final DeleteRecipeFromFavoritesDataAccessInterface userDataAccess;
    private final DeleteRecipeFromFavoritesOutputBoundary presenter;

    public DeleteRecipeFromFavoritesInteractor(DeleteRecipeFromFavoritesDataAccessInterface userDataAccess, DeleteRecipeFromFavoritesOutputBoundary presenter) {
        this.userDataAccess = userDataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(DeleteRecipeFromFavoritesInputData inputData) {
    }
}
