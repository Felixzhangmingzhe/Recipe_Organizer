package use_case.edit_recipe;

public class EditRecipeInputData {
    private final String recipeTitle;
    private final String recipeContent;

    public EditRecipeInputData(String recipeTitle, String recipeContent) {
        this.recipeTitle = recipeTitle;
        this.recipeContent = recipeContent;
    }

    public String getTitle() {
        return recipeTitle;
    }
    public String getContent() {
        return recipeContent;
    }
}
