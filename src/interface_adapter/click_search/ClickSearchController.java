package interface_adapter.click_search;

import use_case.click_search.ClickSearchInputBoundary;
import use_case.click_search.ClickSearchInputData;

public class ClickSearchController {

    final ClickSearchInputBoundary clickSearchInteractor;

    public ClickSearchController(ClickSearchInputBoundary clickSearchInteractor) {
        this.clickSearchInteractor = clickSearchInteractor;
    }

    public void execute(String searchQuery) {
        ClickSearchInputData clickSearchInputData = new ClickSearchInputData(searchQuery);
        clickSearchInteractor.clickSearch(clickSearchInputData);
    }
}
