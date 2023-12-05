package use_case.Back;

public class BackInteractor implements BackInputBoundary{
    // Data access interface and presenter
    private final BackDataAccessInterface backUserDataAccessInterface;
    private final BackOutputBoundary backPresenter;

    // Constructor
    public BackInteractor(BackOutputBoundary presenter , BackDataAccessInterface backDataAccessInterface) {
        this.backUserDataAccessInterface = backDataAccessInterface;
        this.backPresenter = presenter;
    }

    // Implementation of execute method in Input Boundary
    @Override
    public void execute() {
        int numOfCooked = backUserDataAccessInterface.getNumOfCooked();
        BackOutputData backOutputData = new BackOutputData(numOfCooked);
        backPresenter.prepareSuccessView(backOutputData);
    }
}
