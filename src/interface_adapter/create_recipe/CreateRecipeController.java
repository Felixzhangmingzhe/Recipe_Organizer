package interface_adapter.create_recipe;

import use_case.create_recipe.CreateRecipeInputBoundary;
import use_case.create_recipe.CreateRecipeInputData;

public class CreateRecipeController {
    final CreateRecipeInputBoundary createRecipeUseCaseInteractor;

    public CreateRecipeController(CreateRecipeInputBoundary createRecipeUseCaseInteractor) {
        this.createRecipeUseCaseInteractor = createRecipeUseCaseInteractor;
    }
  
    public void execute(String title, String content) {
        CreateRecipeInputData createRecipeInputData = new CreateRecipeInputData(title, content);
        createRecipeUseCaseInteractor.execute(createRecipeInputData);
    }
}
