package interface_adapter.create_recipe;

import use_case.create_recipe.CreateRecipeInputBoundary;

public class CreateRecipeController {
    final CreateRecipeInputBoundary createRecipeUseCaseInteractor;

    public CreateRecipeController(CreateRecipeInputBoundary createRecipeUseCaseInteractor) {
        this.createRecipeUseCaseInteractor = createRecipeUseCaseInteractor;
    }
    public void execute() {
        createRecipeUseCaseInteractor.execute();
    }
}
