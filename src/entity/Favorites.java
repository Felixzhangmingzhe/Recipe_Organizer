package entity;

import entity.Recipe;

import java.util.ArrayList;

public class Favorites {
    private int id;
    private ArrayList<Recipe> recipes;
    Favorites(int id, Recipe recipe) {
        this.id = id;
        this.recipes = new ArrayList<Recipe>();
    }
    public int getId() {
        return this.id;
    }
    public ArrayList<Recipe> getRecipes() {
        return this.recipes;
}
