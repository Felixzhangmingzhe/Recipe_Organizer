package use_case.create_recipe;

import entity.Recipe;
import org.json.JSONException;

public interface CreateRecipeUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(Recipe recipe) throws JSONException;

    int getLastUsedRecipeIdFromDatabase();
}