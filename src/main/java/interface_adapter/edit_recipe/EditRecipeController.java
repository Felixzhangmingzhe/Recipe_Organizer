package interface_adapter.edit_recipe;

import org.json.JSONException;

import use_case.edit_recipe.EditRecipeInputBoundary;
import use_case.edit_recipe.EditRecipeInputData;

public class EditRecipeController {
    private final EditRecipeInputBoundary interactor;

    public EditRecipeController(EditRecipeInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String OriginalRecipeTitle, String recipeTitle, String recipeContent) throws JSONException {
        EditRecipeInputData inputData = new EditRecipeInputData(OriginalRecipeTitle, recipeTitle, recipeContent);
        interactor.execute(inputData);
    }
}
