package interface_adapter.view_recipe;

import use_case.view_recipe.ViewRecipeOutputBoundary;
import use_case.view_recipe.ViewRecipeOutputData;

import javax.swing.text.View;

public class ViewRecipePresenter {
    public class ViewRecipePresenter implements ViewRecipeOutputBoundary {
        private final View view;

        public ViewRecipePresenter(View view) {
            this.view = view;
        }

        @Override
        public void presentRecipe(ViewRecipeOutputData outputData) {
            RecipeViewModel viewModel = new RecipeViewModel(outputData.getRecipe());
            view.displayRecipeDetails(viewModel);
        }
    }
}
