package use_case.edit_recipe;

public class EditRecipeOutputData {
    private final boolean success;
    private final String message;

    public EditRecipeOutputData(boolean success, String message) {
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
