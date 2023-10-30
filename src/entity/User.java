package entity;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    private int id;
    private String username;
    private String password;
    private ArrayList<entity.Favorites> favorites;
    private ArrayList<Recipe> recipes;
    User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.favorites = new ArrayList<entity.Favorites>();
        this.recipes = new ArrayList<Recipe>();
    }

    public void setId(int id){
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFavorites(ArrayList<Favorites> favoritesArrayList){
        this.favorites = favoritesArrayList;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.recipes = recipes;
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
    public ArrayList<entity.Favorites> getFavorites() {
        return this.favorites;
    }
    public ArrayList<Recipe> getRecipes() {
        return this.recipes;
    }
    public void addFavorites (entity.Favorites favorites){
        this.favorites.add(favorites);
    }



}
