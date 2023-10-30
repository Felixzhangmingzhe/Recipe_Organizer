package entity;

import entity.Recipe;

public class Favorites {
    private int id;
    private String name;
    private Recipe recipe;

    Favorites(int id, String name, Recipe recipe) {
        this.id = id;
        this.name = name;
        this.recipe = recipe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public int getId() {
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public Recipe getRecipe() {
        return this.recipe;
    }
}
