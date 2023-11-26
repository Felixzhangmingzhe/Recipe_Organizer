package interface_adapter.edit_recipe;

import use_case.edit_recipe.*;

public class EditRecipeController {
    private final EditRecipeInputBoundary interactor;

    public EditRecipeController(EditRecipeInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String recipeId, String updatedRecipeDetails) {
        EditRecipeInputData inputData = new EditRecipeInputData(recipeId, updatedRecipeDetails);
        interactor.execute(inputData);
    }
}
