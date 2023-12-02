package use_case.click_search;

import java.io.IOException;

public interface ClickSearchInputBoundary {
    void clickSearch(ClickSearchInputData inputData) throws IOException;
}
