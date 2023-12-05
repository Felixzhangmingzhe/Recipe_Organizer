package use_case.add_to_favorites;

import entity.Recipe;

public class AddToFavoritesInteractor implements AddToFavoritesInputBoundary {
    // Data access interface and presenter
    private final AddToFavoritesDataAccessInterface AddToFavoritesUserDataAccessInterface;
    private final AddToFavoritesOutputBoundary AddToFavoritesPresenter;

    // Constructor
    public AddToFavoritesInteractor(AddToFavoritesDataAccessInterface userDataAccess, AddToFavoritesOutputBoundary presenter) {
        this.AddToFavoritesUserDataAccessInterface = userDataAccess;
        this.AddToFavoritesPresenter = presenter;
    }

    // Implementation of execute method in Input Boundary
    @Override
    public void execute(AddToFavoritesInputData inputData) {
        // Retrieve recipe by title
        Recipe recipe = AddToFavoritesUserDataAccessInterface.getRecipeByTitle(inputData.getTitle());

        // Check if recipe is already in favorites
        if (recipe.getIsFavorite()) {
            // remove from favorites
            boolean isFavorite = false;
            AddToFavoritesUserDataAccessInterface.updateRecipe(recipe.getId(), recipe.getTitle(), recipe.getContent(), recipe.getDate(),isFavorite , recipe.getIsCooked(), recipe.getCalories());
            // Output data indicating removed from favorites
            AddToFavoritesOutputData outputData = new AddToFavoritesOutputData("", "Recipe is deleted from favorites");
            AddToFavoritesPresenter.prepareSuccessView(outputData);
        } else {
            // add to favorites
            boolean isFavorite = true;
            AddToFavoritesUserDataAccessInterface.updateRecipe(recipe.getId(), recipe.getTitle(), recipe.getContent(), recipe.getDate(), isFavorite, recipe.getIsCooked(), recipe.getCalories());
            // Output data indicating added to favorites
            AddToFavoritesOutputData outputData = new AddToFavoritesOutputData("Recipe is added to favorites", "" );
            AddToFavoritesPresenter.prepareSuccessView(outputData);
        }
    }
}
