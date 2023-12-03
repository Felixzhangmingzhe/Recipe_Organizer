package use_case.edit_recipe;

public class EditRecipeInputData {
    private final String recipeTitle;

    public EditRecipeInputData(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public String getTitle() {
        return recipeTitle;
    }
}
