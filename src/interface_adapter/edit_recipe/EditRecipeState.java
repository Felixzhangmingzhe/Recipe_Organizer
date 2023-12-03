package interface_adapter.edit_recipe;

public class EditRecipeState {
    private String EditRecipeMessage = "";
    public EditRecipeState(EditRecipeState state) {
        this.EditRecipeMessage = state.EditRecipeMessage;
    }
    public EditRecipeState() {
    }
    public String getEditRecipeMessage() {
        return EditRecipeMessage;
    }
    public void setEditRecipeMessage(String editRecipeMessage) {
        EditRecipeMessage = editRecipeMessage;
    }
}
