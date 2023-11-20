package entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FavoritesFactory {
    public static Favorites createFavorites(int id, ArrayList<Recipe> recipes) {
        return new Favorites(id, recipes);
    }
}
