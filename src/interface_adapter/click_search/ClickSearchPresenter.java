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
        state.setRecipes(outputData.getSearchedRecipes());
        // System.out.println(state.getRecipes());
        // state.setSearchedRecipes(outputData.getSearchedRecipes()); //这是用warehouseView之前的数据
        clickSearchViewModel.setState(state);
        clickSearchViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(clickSearchViewModel.getViewName());
        // System.out.println("这里的viewname应该是warehouse"+clickSearchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println("SuccessView");
    }

    @Override
    public void prepareFailView(String error) {
        System.out.println("click search presenter error");
        if (error.equals("No recipes found")) {
            ClickSearchState state = clickSearchViewModel.getState();
            state.setRecipesError("Cannot find recipe");
            clickSearchViewModel.firePropertyChanged();
            viewManagerModel.setActiveView("search");
            viewManagerModel.firePropertyChanged();
        }
    }
}
