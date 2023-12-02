package use_case.click_search;

import entity.Recipe;

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
            clickSearchPresenter.prepareSuccessView(clickSearchOutputData);
        }catch (IOException e) {
            clickSearchPresenter.prepareFailView(e.getMessage());
        }

    }
}
