package interface_adapter.Back;

import use_case.Back.BackInputBoundary;

public class BackController {
    private BackInputBoundary backUseCaseInteractor;
    public BackController(BackInputBoundary backUseCaseInteractor) {
        this.backUseCaseInteractor = backUseCaseInteractor;
    }
    public void execute() {
        backUseCaseInteractor.execute();
    }
}
