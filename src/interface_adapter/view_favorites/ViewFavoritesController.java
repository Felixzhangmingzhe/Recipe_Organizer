package interface_adapter.view_favorites;

import use_case.view_favorites.ViewFavoritesInputBoundary;
import use_case.view_favorites.ViewFavoritesInputData;

public class ViewFavoritesController {
    private final ViewFavoritesInputBoundary viewFavoritesInteractor;


    public ViewFavoritesController(ViewFavoritesInputBoundary viewFavoritesInteractor) {
        this.viewFavoritesInteractor = viewFavoritesInteractor;

    }

    public void execute() {
         ViewFavoritesInputData viewFavoritesInputData= new ViewFavoritesInputData();
        viewFavoritesInteractor.execute();
    }
}
