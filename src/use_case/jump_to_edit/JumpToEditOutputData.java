package use_case.jump_to_edit;

public class JumpToEditOutputData {
    private final String recipeTitle;
    private final String recipeContent;

    public JumpToEditOutputData(String recipeTitle, String recipeContent) {
        this.recipeTitle = recipeTitle;
        this.recipeContent = recipeContent;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public String getRecipeContent() {
        return recipeContent;
    }
}
