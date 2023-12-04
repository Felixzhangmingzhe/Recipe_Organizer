package use_case.click_search;

public interface ClickSearchOutputBoundary {
    // Success
    void prepareSuccessView(ClickSearchOutputData outputData);

    // Fail
    void prepareFailView(String error);
}
