package use_case.Back;

public class BackInteractor implements BackInputBoundary{
    // Data access interface and presenter
    private BackOutputBoundary presenter;
    private BackDataAccessInterface backDataAccessInterface;

    // Constructor
    public BackInteractor(BackOutputBoundary presenter , BackDataAccessInterface backDataAccessInterface) {
        this.backDataAccessInterface = backDataAccessInterface;
        this.presenter = presenter;
    }

    // Implementation of execute method in Input Boundary
    @Override
    public void execute() {
        int numOfCooked = backDataAccessInterface.getNumOfCooked();
        BackOutputData backOutputData = new BackOutputData(numOfCooked);
        presenter.prepareSuccessView(backOutputData);
    }
}
