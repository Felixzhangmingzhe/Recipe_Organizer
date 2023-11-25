package interface_adapter.add_to_favorites;

public class AddToFavoritesController {
    private final AddToFavoritesInputBoundary interactor;

    public AddToFavoritesController(AddToFavoritesInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String recipeId) {
        AddToFavoritesInputData inputData = new AddToFavoritesInputData(recipeId);
        interactor.execute(inputData);
    }
}
