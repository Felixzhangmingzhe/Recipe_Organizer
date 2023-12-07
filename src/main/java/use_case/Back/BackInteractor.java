package use_case.Back;

public class BackInteractor implements BackInputBoundary{
    private BackOutputBoundary presenter;
    private BackDataAccessInterface backDataAccessInterface;
    public BackInteractor(BackOutputBoundary presenter , BackDataAccessInterface backDataAccessInterface) {
        this.backDataAccessInterface = backDataAccessInterface;
        this.presenter = presenter;
    }
    @Override
    public void execute() {
        int numOfCooked = backDataAccessInterface.getNumOfCooked();
        BackOutputData backOutputData = new BackOutputData(numOfCooked);
        presenter.prepareSuccessView(backOutputData);
    }
}
