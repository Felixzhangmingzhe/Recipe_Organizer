package interface_adapter.view_recipe;

import interface_adapter.ViewManagerModel;
import use_case.view_recipe.ViewRecipeOutputBoundary;
import use_case.view_recipe.ViewRecipeOutputData;

import javax.swing.text.View;

public class ViewRecipePresenter implements ViewRecipeOutputBoundary {
    private final ViewRecipeViewModel viewRecipeViewModel;
    private ViewManagerModel viewManagerModel;
    public ViewRecipePresenter(ViewRecipeViewModel viewRecipeViewModel, ViewManagerModel viewManagerModel) {
        this.viewRecipeViewModel = viewRecipeViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ViewRecipeOutputData outputData) {
        viewRecipeViewModel.setTitle(outputData.getTitle());
        viewRecipeViewModel.setContent(outputData.getContent());
        viewRecipeViewModel.setCreationTime(outputData.getCreationTime());
        viewRecipeViewModel.setCalories(outputData.getCalories());
        viewRecipeViewModel.setIsFavorite(outputData.getIsFavorite());
        viewRecipeViewModel.setIsCooked(outputData.getIsCooked());
        viewRecipeViewModel.firePropertyChanged();// this evt is recipe.
        viewManagerModel.setActiveView(viewRecipeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        viewRecipeViewModel.setNoRecipeFoundMessage(errorMessage);
        viewRecipeViewModel.firePropertyChanged();
        // TODO: warehouse or favotites
    }
}


