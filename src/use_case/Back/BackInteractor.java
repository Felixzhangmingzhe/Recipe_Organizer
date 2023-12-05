package use_case.Back;

public class BackInteractor implements BackInputBoundary{
    // Data access interface and presenter
    private final BackDataAccessInterface backUserDataAccessInterface;
    private final BackOutputBoundary backPresenter;

    // Constructor
    public BackInteractor(BackOutputBoundary backPresenter , BackDataAccessInterface backUserDataAccessInterface) {
        this.backUserDataAccessInterface = backUserDataAccessInterface;
        this.backPresenter = backPresenter;
    }

    // Implementation of execute method in Input Boundary
    @Override
    public void execute() {
        int numOfCooked = backUserDataAccessInterface.getNumOfCooked();
        // Output data indicating back to main view
        BackOutputData backOutputData = new BackOutputData(numOfCooked);
        backPresenter.prepareSuccessView(backOutputData);
    }
}
