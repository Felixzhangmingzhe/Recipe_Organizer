package interface_adapter.view_favorites;

import interface_adapter.ViewManagerModel;
import use_case.view_favorites.ViewFavoritesOutputBoundary;
import use_case.view_favorites.ViewFavoritesOutputData;
import view.FavoritesView;
import view.ViewManager;
import interface_adapter.view_recipe.ViewRecipeViewModel;

public class ViewFavoritesPresenter implements ViewFavoritesOutputBoundary{
    private final ViewFavoritesViewModel viewFavoritesViewModel;
    private final ViewRecipeViewModel viewRecipeViewModel;
    private ViewManagerModel viewManagerModel;

    public ViewFavoritesPresenter(ViewFavoritesViewModel viewFavoritesViewModel, ViewManagerModel viewManagerModel, ViewRecipeViewModel viewRecipeViewModel) {
        this.viewFavoritesViewModel = viewFavoritesViewModel;
        this.viewManagerModel = viewManagerModel;
        this.viewRecipeViewModel = viewRecipeViewModel;
    }

    @Override
    public void prepareSuccessView(ViewFavoritesOutputData viewFavoritesOutputData) {
        viewFavoritesViewModel.setRecipes(viewFavoritesOutputData.getRecipes());
        viewFavoritesViewModel.firePropertyChanged();
        //state在这里整合进了viewManagerModel，这样不知道行不行得通。
        viewManagerModel.setActiveView(viewFavoritesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
