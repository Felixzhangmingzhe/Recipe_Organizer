package use_case.add_to_favorites;

public class AddToFavoritesOutputData {
    private String AddToFavoritesMessage = "";
    private String DeleteFromFavoritesMessage = "";

    public AddToFavoritesOutputData(String addToFavoritesMessage, String deleteFromFavoritesMessage) {
        this.AddToFavoritesMessage = addToFavoritesMessage;
        this.DeleteFromFavoritesMessage = deleteFromFavoritesMessage;
    }

    public String getAddToFavoritesMessage() {
        return AddToFavoritesMessage;
    }

    public String getDeleteFromFavoritesMessage() {
        return DeleteFromFavoritesMessage;
    }
}
