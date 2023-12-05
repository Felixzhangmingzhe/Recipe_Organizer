package use_case.jump_to_edit;

import entity.Recipe;

public class JumpToEditInteractor implements JumpToEditInputBoundary {
    // Data access interface and presenter
    private final JumpToEditDataAccessInterface jumpToEditDataAccessInterface;
    private final JumpToEditOutputBoundary jumpToEditPresenter;

    // Constructor
    public JumpToEditInteractor(JumpToEditDataAccessInterface jumpToEditDataAccessInterface, JumpToEditOutputBoundary jumpToEditPresenter) {
        this.jumpToEditDataAccessInterface = jumpToEditDataAccessInterface;
        this.jumpToEditPresenter = jumpToEditPresenter;
    }

    // Implementation of execute method in Input Boundary
    @Override
    public void execute(JumpToEditInputData inputData) {
        // Retrieve recipe by title
        Recipe recipe = jumpToEditDataAccessInterface.getRecipeByTitle(inputData.getRecipeTitle());
        // Output data indicating jump to edit
        JumpToEditOutputData outputData = new JumpToEditOutputData(recipe.getTitle(), recipe.getContent(), recipe.getId(), recipe.getIsFavorite(), recipe.getCalories(), recipe.getIsCooked(), recipe.getDate());
        jumpToEditPresenter.prepareSuccessView(outputData);
    }
}