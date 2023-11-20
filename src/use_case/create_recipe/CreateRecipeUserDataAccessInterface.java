package use_case.create_recipe;

import entity.Recipe;

public interface CreateRecipeUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(Recipe recipe);

    int getLastUsedRecipeIdFromDatabase();
}