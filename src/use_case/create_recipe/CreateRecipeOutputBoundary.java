package use_case.create_recipe;

public interface CreateRecipeOutputBoundary {
    void prepareSuccessView(CreateRecipeOutputData recipe);

    void prepareFailView(String error);
}
