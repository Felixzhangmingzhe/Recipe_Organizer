package entity;

import entity.Recipe;
import java.util.ArrayList;
import java.util.List;

public class Favorites {
    private int id;
    private ArrayList<Recipe> recipes;

    public Favorites(int id, ArrayList<Recipe> recipes) {
        this.id = id;
        this.recipes = recipes;
        // 这里是直接传入recipes作为参数呢，还是要用一个新的ArrayList，然后再写一个addRecipe方法呢？
    }

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }
    public int getId() {
        return this.id;
    }

    public ArrayList<Recipe> getRecipes() {
        return this.recipes;
    }
}