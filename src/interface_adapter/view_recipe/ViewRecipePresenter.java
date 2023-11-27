package interface_adapter.view_recipe;

import interface_adapter.ViewManagerModel;
import use_case.view_recipe.ViewRecipeOutputBoundary;
import use_case.view_recipe.ViewRecipeOutputData;


import javax.swing.text.View;

public class ViewRecipePresenter implements ViewRecipeOutputBoundary {
    private final ViewRecipeViewModel viewRecipeViewModel;
    private final ViewManagerModel viewManagerModel;


    public ViewRecipePresenter(ViewRecipeViewModel viewRecipeViewModel, ViewManagerModel viewManagerModel) {
        this.viewRecipeViewModel = viewRecipeViewModel;
           this.viewManagerModel = viewManagerModel;

    }

    @Override
    public void presentRecipe(ViewRecipeOutputData viewRecipeOutputData) {
        viewRecipeViewModel.setRecipe(viewRecipeOutputData.getRecipe());
        viewRecipeViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(viewRecipeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}


