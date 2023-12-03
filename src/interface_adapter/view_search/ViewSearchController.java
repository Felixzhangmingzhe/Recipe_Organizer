package interface_adapter.view_search;

import use_case.view_search.ViewSearchInputBoundary;

public class ViewSearchController {

    private final ViewSearchInputBoundary viewSearchInteractor;

    public ViewSearchController(ViewSearchInputBoundary viewSearchInteractor) {
        this.viewSearchInteractor = viewSearchInteractor;
    }
    public void execute() {

        viewSearchInteractor.execute();
    }

}
