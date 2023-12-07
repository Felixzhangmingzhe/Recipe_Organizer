package use_case.view_favorites;

import entity.Recipe;

import java.util.List;

public class ViewFavoritesInteractor implements ViewFavoritesInputBoundary {
    private final ViewFavoritesOutputBoundary viewFavoritesPresenter;
    private final ViewFavoritesDataAccessInterface viewFavoritesDataAccessInterface;


    public ViewFavoritesInteractor(
            ViewFavoritesOutputBoundary viewFavoritesPresenter,
            ViewFavoritesDataAccessInterface viewFavoritesDataAccessInterface) {
        this.viewFavoritesPresenter = viewFavoritesPresenter;
        this.viewFavoritesDataAccessInterface = viewFavoritesDataAccessInterface;}

    public void execute() {
        List<Recipe> recipes = viewFavoritesDataAccessInterface.getFavorites();
        ViewFavoritesOutputData viewFavoritesOutputData = new ViewFavoritesOutputData(recipes);
        viewFavoritesPresenter.prepareSuccessView(viewFavoritesOutputData);
    }


}
