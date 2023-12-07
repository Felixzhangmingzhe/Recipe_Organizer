package use_case.click_search;

public interface ClickSearchOutputBoundary {

    void prepareSuccessView(ClickSearchOutputData outputData);

    void prepareFailView(String error);
}
