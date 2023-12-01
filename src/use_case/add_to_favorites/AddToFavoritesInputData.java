package use_case.add_to_favorites;

import entity.Recipe;

public class AddToFavoritesInputData {
    private final int id;
    private final String title;

    public AddToFavoritesInputData(String title, int id) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    int getId() {
        return id;
    }
}
