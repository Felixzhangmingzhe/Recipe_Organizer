package use_case.click_search;

import entity.Recipe;

import java.util.List;

public class ClickSearchOutputData {
    private final List<Recipe> searchedRecipes;

    public ClickSearchOutputData(List<Recipe> searchedRecipes) {
        this.searchedRecipes = searchedRecipes;
    }

    public List<Recipe> getSearchedRecipes() {
        return searchedRecipes;
    }

}
