package use_case.click_search;

import entity.Recipe;

import java.util.List;

public interface ClickSearchDataAccessInterface {

    boolean isRecipeExist(String title);
    List<Recipe> getRecipesFromAPI(String title);


}
