package use_case.create_recipe;
import entity.Recipe;
import entity.RecipeFactory;

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
        //** TODO: Implement this method
        if (createRecipeInputData.getTitle().equals("")) {
            createRecipeOutputBoundary.prepareFailView("Title is empty");
        } else if (createRecipeInputData.getContent().equals("")) {
            createRecipeOutputBoundary.prepareFailView("Content is empty");
        } else {
            int id = 0;//** TODO: Get the next id from the database
            LocalDateTime now = LocalDateTime.now();
            Recipe recipe = recipeFactory.create(id, createRecipeInputData.getTitle(), createRecipeInputData.getContent(), now);
            createRecipeUserDataAccessInterface.save(recipe);


            //** TODO: Output the recipe to the view
            CreateRecipeOutputData createRecipeOutputData = new CreateRecipeOutputData(recipe.getTitle(), recipe.getContent(), recipe.getDate().toString(), false);

        }
    }
}
