package interface_adapter.click_search;

import entity.Recipe;
import interface_adapter.view_warehouse.ViewWarehouseState;

import java.util.List;

public class ClickSearchState extends ViewWarehouseState {

    private String searchQuery;
    private String searchError;

    private List<Recipe> recipes = new java.util.ArrayList<>();
    private String recipesError = null;


    public ClickSearchState() {
        super();
        this.searchQuery = "";
        this.searchError = null;
    }

    @Override
    public List<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public String getRecipesError() {
        return recipesError;
    }

    @Override
    public void setRecipesError(String recipesError) {
        this.recipesError = recipesError;
    }

    public String getSearchError() {
        return searchError;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchError(String searchError) {
        this.searchError = searchError;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }
}
