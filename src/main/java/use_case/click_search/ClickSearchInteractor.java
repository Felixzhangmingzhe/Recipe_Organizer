package use_case.click_search;

import entity.Recipe;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class ClickSearchInteractor implements ClickSearchInputBoundary{

    private final ClickSearchOutputBoundary clickSearchPresenter;
    private final ClickSearchDataAccessInterface clickSearchDataAccess;

    public ClickSearchInteractor(ClickSearchOutputBoundary clickSearchPresenter, ClickSearchDataAccessInterface clickSearchDataAccess) {
        this.clickSearchPresenter = clickSearchPresenter;
        this.clickSearchDataAccess = clickSearchDataAccess;
    }


    @Override
    public void clickSearch(ClickSearchInputData inputData) {
        try{
            List<Recipe> recipes = clickSearchDataAccess.getRecipesFromAPI(inputData.getTitle());
            ClickSearchOutputData clickSearchOutputData = new ClickSearchOutputData(recipes);
            System.out.println("clickSearchInteractor");
            for (Recipe recipe : recipes) {
                System.out.println(recipe.getTitle());
            }
            if (recipes.size() == 0){
                clickSearchPresenter.prepareFailView("No recipes found");
            } else if(recipes == null){
                clickSearchPresenter.prepareFailView("Cannot find recipe");
            }
            else {
                clickSearchPresenter.prepareSuccessView(clickSearchOutputData);
            }
        }catch (IOException | JSONException e) {
            clickSearchPresenter.prepareFailView(e.getMessage());
        }

    }
}
