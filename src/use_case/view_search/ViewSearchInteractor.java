package use_case.view_search;

public class ViewSearchInteractor implements ViewSearchInputBoundary{
    // Presenter
    private final ViewSearchOutputBoundary viewSearchPresenter;

    // Constructor
    public ViewSearchInteractor(ViewSearchOutputBoundary viewSearchPresenter) {
        this.viewSearchPresenter = viewSearchPresenter;
    }

    @Override
    public void execute(){
        viewSearchPresenter.prepareSuccessView();
    }
}
