package use_case.add_to_favorites;

public class AddToFavoritesOutputData {
    // Adding and deleting messages
    private String AddToFavoritesMessage = "";
    private String DeleteFromFavoritesMessage = "";

    // Constructor
    public AddToFavoritesOutputData(String addToFavoritesMessage, String deleteFromFavoritesMessage) {
        this.AddToFavoritesMessage = addToFavoritesMessage;
        this.DeleteFromFavoritesMessage = deleteFromFavoritesMessage;
    }

    // Getter methods
    public String getAddToFavoritesMessage() {
        return AddToFavoritesMessage;
    }

    public String getDeleteFromFavoritesMessage() {
        return DeleteFromFavoritesMessage;
    }
}
