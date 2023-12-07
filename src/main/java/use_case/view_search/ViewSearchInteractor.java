package use_case.view_search;

public class ViewSearchInteractor implements ViewSearchInputBoundary{
    private final ViewSearchOutputBoundary viewSearchPresenter;
//    private final ViewSearchDataAccessInterface viewSearchDataAccessInterface;

    public ViewSearchInteractor(ViewSearchOutputBoundary viewSearchPresenter) {
        this.viewSearchPresenter = viewSearchPresenter;
    }

    public void execute(){
        viewSearchPresenter.prepareSuccessView();

    }
}
