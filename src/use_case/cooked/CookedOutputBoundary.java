package use_case.cooked;

import entity.Recipe;

public interface CookedOutputBoundary {
    void prepareFailView(CookedOutputData outputData);

    void prepareSuccessView(CookedOutputData outputData);
}
