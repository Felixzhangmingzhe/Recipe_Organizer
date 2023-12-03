package interface_adapter.jump_to_edit;

import entity.Recipe;

public class JumpToEditState {
    private String recipeTitle;
    private String recipeContent;

    public JumpToEditState() {
    }

    // 修改的复制构造函数
    public JumpToEditState(JumpToEditState copy) {
        this.recipeTitle = copy.recipeTitle;
        this.recipeContent = copy.recipeContent;
    }

    // Getters
    public String getRecipeTitle() {
        return recipeTitle;
    }

    public String getRecipeContent() {
        return recipeContent;
    }

    // Setters
    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public void setRecipeContent(String content) {
        this.recipeContent = content;
    }
}
