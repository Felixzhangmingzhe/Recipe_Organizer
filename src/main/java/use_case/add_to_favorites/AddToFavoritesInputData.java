package use_case.add_to_favorites;

public class AddToFavoritesInputData {
    private final String title;

    // Constructor
    public AddToFavoritesInputData(String title) {
        this.title = title;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }
}
