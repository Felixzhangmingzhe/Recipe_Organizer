package interface_adapter.click_search;

import use_case.click_search.ClickSearchInputBoundary;
import use_case.click_search.ClickSearchInputData;

import java.io.IOException;

public class ClickSearchController {

    final ClickSearchInputBoundary clickSearchInteractor;

    public ClickSearchController(ClickSearchInputBoundary clickSearchInteractor) {
        this.clickSearchInteractor = clickSearchInteractor;
    }

    public void execute(String searchQuery) {
        ClickSearchInputData clickSearchInputData = new ClickSearchInputData(searchQuery);
        try{
            clickSearchInteractor.clickSearch(clickSearchInputData);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        // TODO: 这里可以FailView吗

    }
}
