package use_case.click_search;

import entity.Recipe;

import java.util.List;

public class ClickSearchOutputData {
    // List of recipes that match search
    private final List<Recipe> searchedRecipes;

    // Constructor
    public ClickSearchOutputData(List<Recipe> searchedRecipes) {
        this.searchedRecipes = searchedRecipes;
    }

    // Getter method
    public List<Recipe> getSearchedRecipes() {
        return searchedRecipes;
    }

}
