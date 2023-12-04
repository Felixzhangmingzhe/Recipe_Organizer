package use_case.click_search;

import entity.Recipe;

import java.io.IOException;
import java.util.List;

public class ClickSearchInteractor implements ClickSearchInputBoundary{
    // Data access interface and presenter
    private final ClickSearchDataAccessInterface clickSearchDataAccess;
    private final ClickSearchOutputBoundary clickSearchPresenter;

    // Constructor
    public ClickSearchInteractor(ClickSearchOutputBoundary clickSearchPresenter, ClickSearchDataAccessInterface clickSearchDataAccess) {
        this.clickSearchPresenter = clickSearchPresenter;
        this.clickSearchDataAccess = clickSearchDataAccess;
    }

    // Implementation of execute method in Input Boundary
    @Override
    public void clickSearch(ClickSearchInputData inputData) {
        // Try to retrieve recipes from API
        try{
            List<Recipe> recipes = clickSearchDataAccess.getRecipesFromAPI(inputData.getTitle());
            ClickSearchOutputData clickSearchOutputData = new ClickSearchOutputData(recipes);
            // For debugging, print information about the search operation.
            System.out.println("clickSearchInteractor");
            for (Recipe recipe : recipes) {
                System.out.println(recipe.getTitle());
            }
            if (recipes.size() == 0){
                clickSearchPresenter.prepareFailView("No recipes found");
                System.out.println("No recipes found");
            } else if(recipes == null){
                clickSearchPresenter.prepareFailView("Cannot find recipe");
                System.out.println("Cannot find recipe");
            }
            else {
                clickSearchPresenter.prepareSuccessView(clickSearchOutputData);
            }
        }catch (IOException e) {
            clickSearchPresenter.prepareFailView(e.getMessage());
        }

    }
}
