package use_case.Back;

public class BackInteractor implements BackInputBoundary{
    private BackOutputBoundary presenter;
    public BackInteractor(BackOutputBoundary presenter) {
        this.presenter = presenter;
    }
    @Override
    public void execute() {
        presenter.prepareSuccessView();
    }
}
