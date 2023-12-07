package use_case.create_recipe;

import org.json.JSONException;

public interface CreateRecipeInputBoundary {
    void execute(CreateRecipeInputData request) throws JSONException;
}
