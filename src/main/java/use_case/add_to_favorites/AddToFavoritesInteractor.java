package use_case.add_to_favorites;

import entity.Recipe;
import org.json.JSONException;

public class AddToFavoritesInteractor implements AddToFavoritesInputBoundary {
    // Data access interface and presenter
    private final AddToFavoritesDataAccessInterface addToFavoritesUserDataAccessInterface;
    private final AddToFavoritesOutputBoundary addToFavoritesPresenter;

    // Constructor
    public AddToFavoritesInteractor(AddToFavoritesDataAccessInterface addToFavoritesUserDataAccessInterface, AddToFavoritesOutputBoundary addToFavoritesPresenter) {
        this.addToFavoritesUserDataAccessInterface = addToFavoritesUserDataAccessInterface;
        this.addToFavoritesPresenter = addToFavoritesPresenter;
    }

    // Implementation of execute method in Input Boundary
    @Override
    public void execute(AddToFavoritesInputData inputData) throws JSONException {
        // Retrieve recipe by title
        Recipe recipe = addToFavoritesUserDataAccessInterface.getRecipeByTitle(inputData.getTitle());

        // Check if recipe is already in favorites
        if (recipe.getIsFavorite()) {
            // remove from favorites
            boolean isFavorite = false;
            addToFavoritesUserDataAccessInterface.updateRecipe(recipe.getId(), recipe.getTitle(), recipe.getContent(), recipe.getDate(),isFavorite , recipe.getIsCooked(), recipe.getCalories());
            // Output data indicating removed from favorites
            AddToFavoritesOutputData outputData = new AddToFavoritesOutputData("", "Recipe is deleted from favorites");
            addToFavoritesPresenter.prepareSuccessView(outputData);
        } else {
            // add to favorites
            boolean isFavorite = true;
            addToFavoritesUserDataAccessInterface.updateRecipe(recipe.getId(), recipe.getTitle(), recipe.getContent(), recipe.getDate(), isFavorite, recipe.getIsCooked(), recipe.getCalories());
            // Output data indicating added to favorites
            AddToFavoritesOutputData outputData = new AddToFavoritesOutputData("Recipe is added to favorites", "" );
            addToFavoritesPresenter.prepareSuccessView(outputData);
        }
    }
}