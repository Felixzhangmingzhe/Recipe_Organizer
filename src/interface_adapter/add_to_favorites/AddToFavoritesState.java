package interface_adapter.add_to_favorites;

public class AddToFavoritesState {
    private String AddToFavoritesMessage = "";
    private String DeleteFromFavoritesMessage = "";

    public AddToFavoritesState(AddToFavoritesState state) {
        this.AddToFavoritesMessage = state.AddToFavoritesMessage;
        this.DeleteFromFavoritesMessage = state.DeleteFromFavoritesMessage;
    }
    public AddToFavoritesState() {
    }
    public String getAddToFavoritesMessage() {
        return AddToFavoritesMessage;
    }
    public void setAddToFavoritesMessage(String addToFavoritesMessage) {
        AddToFavoritesMessage = addToFavoritesMessage;
    }
    public String getDeleteFromFavoritesMessage() {
        return DeleteFromFavoritesMessage;
    }
    public void setDeleteFromFavoritesMessage(String deleteFromFavoritesMessage) {
        DeleteFromFavoritesMessage = deleteFromFavoritesMessage;
    }
}
