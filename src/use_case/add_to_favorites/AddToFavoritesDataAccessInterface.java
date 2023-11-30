package use_case.add_to_favorites;

public interface AddToFavoritesDataAccessInterface {
    boolean existsById(int recipeId);

    void save(int userId, int recipeId);
}
