package use_case.open_create_recipe;

public class OpenCreateRecipeInteractor implements OpenCreateRecipeInputBoundary {
    // Data access object and presenter
    final OpenCreateRecipeDataAccessInterface openCreateRecipeDataAccessObject;
    final OpenCreateRecipeOutputBoundary openCreateRecipePresenter;

    // Constructor
    public OpenCreateRecipeInteractor(OpenCreateRecipeOutputBoundary openCreateRecipePresenter, OpenCreateRecipeDataAccessInterface dao) {
        this.openCreateRecipeDataAccessObject = dao;
        this.openCreateRecipePresenter = openCreateRecipePresenter;
    }

    // Implementation of execute method in Input Boundary
    @Override
    public void execute() {
        openCreateRecipePresenter.prepareSuccessView();
    }
}
