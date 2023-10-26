package interface_adapter.create_recipe;

public class CreateRecipeViewModel {
    private int recipeId = 0;
    private String recipeTitle = "";
    private String recipeContent = "";
    public void setRecipeId(String recipeId) {
        this.recipeId = Integer.parseInt(recipeId);
    }
    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }
    public void setRecipeContent(String recipeContent) {
        this.recipeContent = recipeContent;
    }

}
