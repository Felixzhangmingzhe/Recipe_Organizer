package entity;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    private int id;
    private String username;
    private String password;

    private ArrayList<Favorites> favorites;

    private ArrayList<Recipe> recipes;
    User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;

        this.favorites = new ArrayList<Favorites>();
        this.recipes = new ArrayList<Recipe>();
    }

    public int getId() {
        return this.id;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }

    public ArrayList<Favorites> getFavorites() {

        return this.favorites;
    }
    public ArrayList<Recipe> getRecipes() {
        return this.recipes;
    }
}
