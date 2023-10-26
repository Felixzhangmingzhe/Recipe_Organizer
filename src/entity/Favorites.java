package entity;

import entity.Recipe;

public class Favorites {
    private int id;
    private Recipe recipe;
    Favorites(int id, Recipe recipe) {
        this.id = id;
        this.recipe = recipe;
    }
    public int getId() {
        return this.id;
    }
    public Recipe getRecipe() {
        return this.recipe;
    }
}
