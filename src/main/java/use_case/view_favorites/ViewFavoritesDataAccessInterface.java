package use_case.view_favorites;

import entity.Recipe;

import java.util.List;

public interface ViewFavoritesDataAccessInterface {
    public List<Recipe> getFavorites();
}
