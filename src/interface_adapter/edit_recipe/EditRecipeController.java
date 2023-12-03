package interface_adapter.edit_recipe;

import use_case.edit_recipe.EditRecipeInputBoundary;
import use_case.edit_recipe.EditRecipeInputData;

public class EditRecipeController {
    private final EditRecipeInputBoundary interactor;

    public EditRecipeController(EditRecipeInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String recipeTitle) {
        EditRecipeInputData inputData = new EditRecipeInputData(recipeTitle);
        interactor.execute(inputData);
    }
}