package use_case.view_warehouse;

import entity.Recipe;

import java.util.List;

public class ViewWarehouseOutputData {
    private List<Recipe> recipes;

    public ViewWarehouseOutputData(List<Recipe> resipes) {
        this.recipes = resipes;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
