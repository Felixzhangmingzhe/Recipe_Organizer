package use_case.cooked;

import entity.Recipe;
import entity.RecipeFactory;

public class CookedInteractor implements CookedInputBoundary{
    private CookedOutputBoundary cookedPresenter;
    private CookedDataAccessInterface cookedDataAccessInterface;
    public CookedInteractor(CookedOutputBoundary cookedPresenter, CookedDataAccessInterface cookedDataAccessInterface) {
        this.cookedPresenter = cookedPresenter;
        this.cookedDataAccessInterface = cookedDataAccessInterface;
    }

    @Override
    public void execute() {
        //Recipe recipe = cookedDataAccessInterface.getRecipeByRecipeTitle(inputData.getRecipeTitle());
        if (true) {//recipe.getCooked())
            CookedOutputData outputData = new CookedOutputData(false);
            // cookedPresenter.prepareFailView(
        } else {
            RecipeFactory recipeFactory = new RecipeFactory();
            // Recipe updatedRecipe = recipeFactory.create(recipe.getId(),recipe.getTitle(),recipe.getContent(),recipe.getDate(),recipe.getIsFavorite(),recipe.getCalories(),true);
            // cookedDataAccessInterface.updateCookedRecipe(updatedRecipe);
            CookedOutputData outputData = new CookedOutputData(true);
            // cookedPresenter.prepareSuccessView(updatedRecipe);
        }

    }
}
