package interface_adapter.view_warehouse;
import entity.Recipe;

import java.util.List;

public class ViewWarehouseState {
    private List<Recipe> recipes = new java.util.ArrayList<>();
    private String recipesError = null;
    public ViewWarehouseState(ViewWarehouseState copy) {
        this.recipes = copy.recipes;
        this.recipesError = copy.recipesError;
    }
    public ViewWarehouseState() {
    }
    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    public List<Recipe> getRecipes() {
        return this.recipes;
    }
    public void setRecipesError(String recipesError) {
        this.recipesError = recipesError;
    }
    public String getRecipesError() {
        return this.recipesError;
    }
}
