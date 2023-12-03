package use_case.jump_to_edit;

import entity.Recipe;

public class JumpToEditInteractor implements JumpToEditInputBoundary {
    private final JumpToEditDataAccessInterface userDataAccess;
    private final JumpToEditOutputBoundary presenter;

    public JumpToEditInteractor(JumpToEditDataAccessInterface userDataAccess, JumpToEditOutputBoundary presenter) {
        this.userDataAccess = userDataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(JumpToEditInputData inputData) {
        Recipe recipe = userDataAccess.getRecipeByTitle(inputData.getRecipeTitle());
        JumpToEditOutputData outputData = new JumpToEditOutputData(recipe.getTitle(), recipe.getContent());
        presenter.prepareSuccessView(outputData);
    }
}