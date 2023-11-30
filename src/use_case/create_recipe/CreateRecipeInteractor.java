// Class: CreateRecipeInteractor
package use_case.create_recipe;

import entity.Recipe;
import entity.RecipeFactory;

import java.time.LocalDateTime;
public class CreateRecipeInteractor implements CreateRecipeInputBoundary{
    final CreateRecipeOutputBoundary createRecipePresenter;
    final CreateRecipeUserDataAccessInterface createRecipeUserDataAccessInterface;
    final RecipeFactory recipeFactory;
    public CreateRecipeInteractor(CreateRecipeOutputBoundary createRecipePresenter, CreateRecipeUserDataAccessInterface createRecipeUserDataAccessInterface, RecipeFactory recipeFactory) {
        this.createRecipePresenter = createRecipePresenter;
        this.createRecipeUserDataAccessInterface = createRecipeUserDataAccessInterface;
        this.recipeFactory = recipeFactory;
    }
    @Override
    public void execute(CreateRecipeInputData createRecipeInputData) {
        if (createRecipeInputData.getTitle().equals("")) {
            createRecipePresenter.prepareFailView("Title is empty");
        } else if (createRecipeInputData.getContent().equals("")) {
            createRecipePresenter.prepareFailView("Content is empty");
        } else {
            int id = getNextRecipeId(); // Implement this method to get the next ID from the database
            LocalDateTime now = LocalDateTime.now();
            double calories = getCalsByName(createRecipeInputData.getTitle());
            Recipe recipe = recipeFactory.create(id, createRecipeInputData.getTitle(), createRecipeInputData.getContent(), now, false,calories);
            createRecipeUserDataAccessInterface.save(recipe);
            // Output the recipe to the view
            CreateRecipeOutputData createRecipeOutputData = new CreateRecipeOutputData(recipe.getTitle(), recipe.getContent(), recipe.getDate().toString(), recipe.getIsFavorite(), recipe.getCalories());
            createRecipePresenter.prepareSuccessView(createRecipeOutputData);
        }
    }

    private double getCalsByName(String title) {
        return -1;// 这样当calorie没有被找到时，就会返回-1，然后在之后显示的时候，遇到-1就会显示“未知”
        // TODO: Implement this method to get the calories from the USDA database,using API.
    }

    private int getNextRecipeId() {
        int lastUsedId = createRecipeUserDataAccessInterface.getLastUsedRecipeIdFromDatabase();
        return lastUsedId + 1;
    }
}
