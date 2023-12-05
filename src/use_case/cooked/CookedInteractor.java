package use_case.cooked;

import entity.Recipe;
import entity.RecipeFactory;

public class CookedInteractor implements CookedInputBoundary{
    // Data access interface and presenter
    private final CookedDataAccessInterface cookedUserDataAccessInterface;
    private final CookedOutputBoundary cookedPresenter;

    // Constructor
    public CookedInteractor(CookedDataAccessInterface cookedUserDataAccessInterface, CookedOutputBoundary cookedPresenter) {
        this.cookedUserDataAccessInterface = cookedUserDataAccessInterface;
        this.cookedPresenter = cookedPresenter;
    }

    // Implementation of execute method in Input Boundary
    @Override
    public void execute(CookedInputData inputData) {
        // Retrieve recipe by title
        Recipe recipe = cookedUserDataAccessInterface.getRecipeByRecipeTitle(inputData.getRecipeTitle());

        // Check if recipe is already cooked
        if (recipe.getIsCooked()) {
            // remove from cooked, or uncooked
            CookedOutputData outputData = new CookedOutputData(false);
            // Output data indicating removed from cooked
            cookedPresenter.prepareFailView(outputData);
        } else {
            // add to cooked
            RecipeFactory recipeFactory = new RecipeFactory();
            Recipe updatedRecipe = recipeFactory.create(recipe.getId(), recipe.getTitle(), recipe.getContent(), recipe.getDate(), recipe.getIsFavorite(),  recipe.getCalories(), true);
            cookedUserDataAccessInterface.updateCookedRecipe(recipe.getId(), recipe.getTitle(), recipe.getContent(), recipe.getDate(), recipe.getIsFavorite(), true, recipe.getCalories());
            CookedOutputData outputData = new CookedOutputData(true);
            // Output data indicating added to cooked
            cookedPresenter.prepareSuccessView(outputData);
        }

    }
}
