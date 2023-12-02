package use_case.click_search;

import entity.Recipe;

import java.io.IOException;
import java.util.List;

public interface ClickSearchDataAccessInterface {

    boolean isRecipeExist(String title);
    List<Recipe> getRecipesFromAPI(String title) throws IOException;


}
