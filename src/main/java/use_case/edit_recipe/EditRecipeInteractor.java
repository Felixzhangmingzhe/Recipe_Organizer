package use_case.edit_recipe;

import entity.Recipe;
import org.json.JSONException;

public class EditRecipeInteractor implements EditRecipeInputBoundary {
    // Data access interface and presenter
    private final EditRecipeDataAccessInterface editRecipeDataAccessInterface;
    private final EditRecipeOutputBoundary editRecipePresenter;

    // Constructor
    public EditRecipeInteractor(EditRecipeDataAccessInterface editRecipeDataAccessInterface, EditRecipeOutputBoundary editRecipePresenter) {
        this.editRecipeDataAccessInterface = editRecipeDataAccessInterface;
        this.editRecipePresenter = editRecipePresenter;
    }

    // Implementation of execute method in Input Boundary
    @Override
    public void execute(EditRecipeInputData inputData) throws JSONException {
        // Retrieve recipe by title
        Recipe recipe = editRecipeDataAccessInterface.getRecipeByTitle(inputData.getOriginalRecipeTiltle());
        String updateTitle = inputData.getTitle();
        String updateContent = inputData.getContent();
        System.out.println("originalTitle: " + inputData.getOriginalRecipeTiltle());
        System.out.println("updateTitle: " + updateTitle);

        // Update recipe with new title and content
        editRecipeDataAccessInterface.updateRecipe(recipe.getId(), updateTitle,updateContent, recipe.getDate(), recipe.getIsFavorite(), recipe.getIsCooked(), recipe.getCalories());
        // Output data indicating recipe updated
        EditRecipeOutputData outputData = new EditRecipeOutputData(updateTitle,updateContent, recipe.getId(), recipe.getIsFavorite(), recipe.getCalories(), recipe.getIsCooked(), recipe.getDate());
        editRecipePresenter.prepareSuccessView(outputData);
    }
}
