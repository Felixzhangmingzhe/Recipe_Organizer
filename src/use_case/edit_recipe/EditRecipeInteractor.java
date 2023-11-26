package use_case.edit_recipe;

public class EditRecipeInteractor implements EditRecipeInputBoundary {
    private final EditRecipeDataAccessInterface userDataAccess;
    private final EditRecipeOutputBoundary presenter;

    public EditRecipeInteractor(EditRecipeDataAccessInterface userDataAccess, EditRecipeOutputBoundary presenter) {
        this.userDataAccess = userDataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(EditRecipeInputData inputData) {

    }
}
