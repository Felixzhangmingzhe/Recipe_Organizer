package use_case.edit_recipe;

import entity.Recipe;

public class EditRecipeInteractor implements EditRecipeInputBoundary {
    private final EditRecipeDataAccessInterface userDataAccess;
    private final EditRecipeOutputBoundary presenter;

    public EditRecipeInteractor(EditRecipeDataAccessInterface userDataAccess, EditRecipeOutputBoundary presenter) {
        this.userDataAccess = userDataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(EditRecipeInputData inputData) {
        // 获取现有菜谱
        Recipe recipe = userDataAccess.getRecipeByTitle(inputData.getOriginalRecipeTiltle());
        String updateTitle = inputData.getTitle();
        String updateContent = inputData.getContent();
        System.out.println("originalTitle: " + inputData.getOriginalRecipeTiltle());
        System.out.println("updateTitle: " + updateTitle);

        // 更新菜谱内容
        userDataAccess.updateRecipe(recipe.getId(), updateTitle,updateContent, recipe.getDate(), recipe.getIsFavorite(), recipe.getIsCooked(), recipe.getCalories());
        EditRecipeOutputData outputData = new EditRecipeOutputData(updateTitle,updateContent, recipe.getId(), recipe.getIsFavorite(), recipe.getCalories(), recipe.getIsCooked(), recipe.getDate());
        presenter.prepareSuccessView(outputData);
    }
}
