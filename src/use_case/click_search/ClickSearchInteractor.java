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
            if (inputData.getTitle().equals("")){
                clickSearchPresenter.prepareFailView("Please enter a title");
                System.out.println("Please enter a title");
            }
            else if(recipes == null){
                clickSearchPresenter.prepareFailView("No recipes found");
                System.out.println("No recipes found");

            } else if (recipes.size() == 0){
                clickSearchPresenter.prepareFailView("No recipes found");
                System.out.println("No recipes found");

            }else{
                ClickSearchOutputData clickSearchOutputData = new ClickSearchOutputData(recipes);
                clickSearchPresenter.prepareSuccessView(clickSearchOutputData);
            }
//            List<Recipe> recipes = clickSearchDataAccess.getRecipesFromAPI(inputData.getTitle());
//            ClickSearchOutputData clickSearchOutputData = new ClickSearchOutputData(recipes);
//            if (recipes.size() == 0){
//                clickSearchPresenter.prepareFailView("No recipes found");
//                System.out.println("No recipes found");
//            }else{
//                clickSearchPresenter.prepareSuccessView(clickSearchOutputData);
//                System.out.println("click search interactor"+recipes);
//            }
        }catch (IOException e) {
            clickSearchPresenter.prepareFailView(e.getMessage());
        }

    }
}
