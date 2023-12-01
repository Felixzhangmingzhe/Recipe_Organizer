package use_case.view_recipe;

public interface ViewRecipeOutputBoundary {

    void prepareSuccessView(ViewRecipeOutputData outputData);

    void prepareFailView(String errorMessage);
}


