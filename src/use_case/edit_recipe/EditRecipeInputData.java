package use_case.edit_recipe;

public class EditRecipeInputData {
    private final String OriginalRecipeTiltle;
    private final String recipeTitle;
    private final String recipeContent;

    public EditRecipeInputData(String OriginalRecipeTiltle, String recipeTitle, String recipeContent) {
        this.OriginalRecipeTiltle = OriginalRecipeTiltle;
        this.recipeTitle = recipeTitle;
        this.recipeContent = recipeContent;
    }

    public String getTitle() {
        return recipeTitle;
    }
    public String getContent() {
        return recipeContent;
    }
    public String getOriginalRecipeTiltle() {
        return OriginalRecipeTiltle;
    }
}
