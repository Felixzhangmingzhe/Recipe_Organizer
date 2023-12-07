package use_case.open_create_recipe;

import data_access.FileRecipeDataAccessObject;

public class OpenCreateRecipeInteractor implements OpenCreateRecipeInputBoundary{
    final OpenCreateRecipeDataAccessInterface openCreateRecipeDataAccessObject;
    final OpenCreateRecipeOutputBoundary openCreateRecipePresenter;

    public OpenCreateRecipeInteractor(OpenCreateRecipeOutputBoundary openCreateRecipePresenter, OpenCreateRecipeDataAccessInterface dao) {
        this.openCreateRecipeDataAccessObject = dao;
        this.openCreateRecipePresenter = openCreateRecipePresenter;
    }

    @Override
    public void execute() {
        openCreateRecipePresenter.prepareSuccessView();
    }
}
