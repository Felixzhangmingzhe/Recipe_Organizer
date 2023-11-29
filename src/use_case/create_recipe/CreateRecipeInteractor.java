// Class: CreateRecipeInteractor
package use_case.create_recipe;

import entity.Recipe;
import entity.RecipeFactory;
import use_case.create_recipe.CreateRecipeInputBoundary;
import use_case.create_recipe.CreateRecipeInputData;
import use_case.create_recipe.CreateRecipeOutputBoundary;
import use_case.create_recipe.CreateRecipeOutputData;
import use_case.create_recipe.CreateRecipeUserDataAccessInterface;
import data_access.InMemoryRecipeDataAccessObject;
import data_access.FileRecipeDataAccessObject;
import java.time.LocalDateTime;
public class CreateRecipeInteractor implements CreateRecipeInputBoundary{
    final CreateRecipeInputBoundary createRecipeInputBoundary;
    final CreateRecipeOutputBoundary createRecipeOutputBoundary;
    final CreateRecipeUserDataAccessInterface createRecipeUserDataAccessInterface;
    final RecipeFactory recipeFactory;
    public CreateRecipeInteractor(CreateRecipeInputBoundary createRecipeInputBoundary, CreateRecipeOutputBoundary createRecipeOutputBoundary, CreateRecipeUserDataAccessInterface createRecipeUserDataAccessInterface, RecipeFactory recipeFactory) {
        this.createRecipeInputBoundary = createRecipeInputBoundary;
        this.createRecipeOutputBoundary = createRecipeOutputBoundary;
        this.createRecipeUserDataAccessInterface = createRecipeUserDataAccessInterface;
        this.recipeFactory = recipeFactory;
    }
    @Override
    public void execute(CreateRecipeInputData createRecipeInputData) {
        if (createRecipeInputData.getTitle().equals("")) {
            createRecipeOutputBoundary.prepareFailView("Title is empty");
        } else if (createRecipeInputData.getContent().equals("")) {
            createRecipeOutputBoundary.prepareFailView("Content is empty");
        } else {
            int id = getNextRecipeId(); // Implement this method to get the next ID from the database
            LocalDateTime now = LocalDateTime.now();
            double calories = getCalsByName(createRecipeInputData.getTitle());
            Recipe recipe = recipeFactory.create(id, createRecipeInputData.getTitle(), createRecipeInputData.getContent(), now, false,calories);
            createRecipeUserDataAccessInterface.save(recipe);

            // Output the recipe to the view
            CreateRecipeOutputData createRecipeOutputData = new CreateRecipeOutputData(recipe.getTitle(), recipe.getContent(), recipe.getDate().toString(), false);
            createRecipeOutputBoundary.prepareSuccessView(createRecipeOutputData);
        }
    }

    private double getCalsByName(String title) {
        // TODO: Implement this method to get the calories from the USDA database,using API.
    }

    private int getNextRecipeId() {
        int lastUsedId = createRecipeUserDataAccessInterface.getLastUsedRecipeIdFromDatabase();
        return lastUsedId + 1;
    }
}
