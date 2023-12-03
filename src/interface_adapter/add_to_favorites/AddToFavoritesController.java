package interface_adapter.add_to_favorites;

import use_case.add_to_favorites.AddToFavoritesInputBoundary;
import use_case.add_to_favorites.AddToFavoritesInputData;

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
