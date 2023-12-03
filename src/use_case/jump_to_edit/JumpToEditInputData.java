package use_case.jump_to_edit;

public class JumpToEditInputData {
    private String recipeTitle;
    private String recipeContent;

    public JumpToEditInputData(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public String getRecipeContent() {
        return recipeContent;
    }
}
