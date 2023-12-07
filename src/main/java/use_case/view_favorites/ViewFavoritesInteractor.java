package use_case.view_favorites;

import entity.Recipe;

import java.util.List;

public class ViewFavoritesInteractor implements ViewFavoritesInputBoundary {
    // Data access interface and presenter
    private final ViewFavoritesDataAccessInterface viewFavoritesDataAccessInterface;
    private final ViewFavoritesOutputBoundary viewFavoritesPresenter;

    // Constructor
    public ViewFavoritesInteractor(ViewFavoritesDataAccessInterface viewFavoritesDataAccessInterface, ViewFavoritesOutputBoundary viewFavoritesPresenter) {
        this.viewFavoritesDataAccessInterface = viewFavoritesDataAccessInterface;
        this.viewFavoritesPresenter = viewFavoritesPresenter;
    }

    // Implementation of execute method in Input Boundary
    public void execute() {
        List<Recipe> recipes = viewFavoritesDataAccessInterface.getFavorites();
        // Output data indicating switch to view favorites
        ViewFavoritesOutputData viewFavoritesOutputData = new ViewFavoritesOutputData(recipes);
        viewFavoritesPresenter.prepareSuccessView(viewFavoritesOutputData);
    }
}
