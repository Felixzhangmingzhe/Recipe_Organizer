package use_case.edit_recipe;

import org.json.JSONException;

public interface EditRecipeInputBoundary {
    void execute(EditRecipeInputData inputData) throws JSONException;
}
