package interface_adapter.click_search;

import entity.Recipe;

import java.util.List;

public class ClickSearchState {

    private String searchQuery;
    private String searchError;

    private List<Recipe> searchedRecipes;


    public ClickSearchState(String searchQuery, String searchError) {
        this.searchQuery = searchQuery;
        this.searchError = searchError;
    }

    public ClickSearchState() {
    }

    public List<Recipe> getSearchedRecipes() {
        return searchedRecipes;
    }

    public void setSearchedRecipes(List<Recipe> searchedRecipes) {
        this.searchedRecipes = searchedRecipes;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public String getSearchError() {
        return searchError;
    }

    public boolean hasSearchError() {
        return searchError != null;
    }

    public void setSearchError(String searchError) {
        this.searchError = searchError;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }
}
