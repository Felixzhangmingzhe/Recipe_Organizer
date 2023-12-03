package use_case.edit_recipe;

public class EditRecipeOutputData {
    private String EditRecipeMessage = "Edit recipe successfully";

    public EditRecipeOutputData(String EditRecipeMessage) {
        this.EditRecipeMessage = EditRecipeMessage;
    }

    public String getEditRecipeMessage() {
        return EditRecipeMessage;
    }
}
