package interface_adapter.jump_to_edit;

import use_case.jump_to_edit.*;

public class JumpToEditController {
    private final JumpToEditInputBoundary interactor;

    public JumpToEditController(JumpToEditInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute(String recipeId) {
        JumpToEditInputData inputData = new JumpToEditInputData(recipeId);
        interactor.execute(inputData);
    }
}
