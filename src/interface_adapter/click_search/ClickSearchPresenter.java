package interface_adapter.click_search;

import interface_adapter.ViewManagerModel;
import use_case.click_search.ClickSearchOutputBoundary;
import use_case.click_search.ClickSearchOutputData;

public class ClickSearchPresenter implements ClickSearchOutputBoundary {

    private final ClickSearchViewModel clickSearchViewModel;
    private final ViewManagerModel viewManagerModel;

    public ClickSearchPresenter(ClickSearchViewModel clickSearchViewModel, ViewManagerModel viewManagerModel) {
        this.clickSearchViewModel = clickSearchViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareSuccessView(ClickSearchOutputData outputData) {
        ClickSearchState state = clickSearchViewModel.getState();
        state.setSearchedRecipes(outputData.getSearchedRecipes());
        clickSearchViewModel.setState(state);
        clickSearchViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(clickSearchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("click search presenter"+outputData.getSearchedRecipes());

    }


    @Override
    public void prepareFailView(String error) {
        if (error.equals("Cannot find recipe")) {
            ClickSearchState state = clickSearchViewModel.getState();
            state.setSearchError("Cannot find recipe");
            clickSearchViewModel.firePropertyChanged();
        }

    }
}
