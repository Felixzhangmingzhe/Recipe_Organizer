package interface_adapter.open_create_recipe;

import use_case.open_create_recipe.OpenCreateRecipeInputBoundary;

public class OpenCreateRecipeController {
    private final OpenCreateRecipeInputBoundary openCreateRecipeInteractor;

    public OpenCreateRecipeController(OpenCreateRecipeInputBoundary openCreateRecipeInteractor) {
        this.openCreateRecipeInteractor = openCreateRecipeInteractor;
    }

    public void execute() {
        openCreateRecipeInteractor.execute();
    }
}
