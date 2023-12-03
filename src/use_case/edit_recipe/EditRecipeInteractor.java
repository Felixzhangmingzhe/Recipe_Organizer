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
        Recipe recipe = userDataAccess.getRecipeByTitle(inputData.getTitle());

        // 更新菜谱内容
        userDataAccess.updateRecipe(recipe.getId(), recipe.getTitle(), recipe.getContent(), recipe.getDate(), recipe.getIsFavorite(), recipe.getIsCooked(), recipe.getCalories());
        EditRecipeOutputData outputData = new EditRecipeOutputData("Recipe edited");
        presenter.prepareSuccessView(outputData);
    }
}
