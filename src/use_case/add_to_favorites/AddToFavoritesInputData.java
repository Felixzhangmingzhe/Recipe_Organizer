package use_case.add_to_favorites;

import entity.Recipe;

public class AddToFavoritesInputData {
    private final String title;

    public AddToFavoritesInputData(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

//    public int getId() {
//
//    }
}
