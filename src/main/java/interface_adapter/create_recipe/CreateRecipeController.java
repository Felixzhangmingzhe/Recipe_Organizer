package interface_adapter.create_recipe;

import org.json.JSONException;
import use_case.create_recipe.CreateRecipeInputBoundary;
import use_case.create_recipe.CreateRecipeInputData;

public class CreateRecipeController {
    final CreateRecipeInputBoundary createRecipeUseCaseInteractor;

    public CreateRecipeController(CreateRecipeInputBoundary createRecipeUseCaseInteractor) {
        this.createRecipeUseCaseInteractor = createRecipeUseCaseInteractor;
    }
  
    public void execute(String title, String content) throws JSONException {
        CreateRecipeInputData createRecipeInputData = new CreateRecipeInputData(title, content);
        createRecipeUseCaseInteractor.execute(createRecipeInputData);
    }


}
