package use_case.click_search;

import entity.Recipe;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class ClickSearchInteractor implements ClickSearchInputBoundary{
    // Data access interface and presenter
    private final ClickSearchDataAccessInterface clickSearchUserDataAccessInterface;
    private final ClickSearchOutputBoundary clickSearchPresenter;

    // Constructor
    public ClickSearchInteractor(ClickSearchDataAccessInterface clickSearchUserDataAccessInterface, ClickSearchOutputBoundary clickSearchPresenter) {
        this.clickSearchUserDataAccessInterface = clickSearchUserDataAccessInterface;
        this.clickSearchPresenter = clickSearchPresenter;
    }

    // Implementation of execute method in Input Boundary
    @Override
    public void clickSearch(ClickSearchInputData inputData) {
        // Try to retrieve recipes from API
        try{
            List<Recipe> recipes = clickSearchUserDataAccessInterface.getRecipesFromAPI(inputData.getTitle());
            ClickSearchOutputData clickSearchOutputData = new ClickSearchOutputData(recipes);
            // For debugging, print information about the search operation.
            System.out.println("clickSearchInteractor");
            for (Recipe recipe : recipes) {
                System.out.println(recipe.getTitle());
            }
            if (recipes.isEmpty()){
                clickSearchPresenter.prepareFailView("No recipes found");
                System.out.println("No recipes found");
            }
            else {
                clickSearchPresenter.prepareSuccessView(clickSearchOutputData);
            }
        } catch (IOException e) {
        }catch (JSONException e) {
        }
    }
}