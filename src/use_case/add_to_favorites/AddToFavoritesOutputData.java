package use_case.add_to_favorites;

public class AddToFavoritesOutputData {
    private final boolean success;
    private final String message;

    public AddToFavoritesOutputData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
