package interface_adapter.create_recipe;

public class CreateRecipeState {
    private String recipeName = "";
    private String recipeNameError = null;
    private String content = "";
    private String contentError = null;

    public CreateRecipeState(CreateRecipeState copy) {
        recipeName = copy.recipeName;
        recipeNameError = copy.recipeNameError;
        content = copy.content;
        contentError = copy.contentError;
    }
    public CreateRecipeState() {
    }
    public String getRecipeName() {
        return recipeName;
    }
    public String getRecipeNameError() {
        return recipeNameError;
    }
    public String getContent() {
        return content;
    }
    public String getContentError() {
        return contentError;
    }
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    public void setRecipeNameError(String recipeNameError) {
        this.recipeNameError = recipeNameError;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setContentError(String contentError) {
        this.contentError = contentError;
    }

}
