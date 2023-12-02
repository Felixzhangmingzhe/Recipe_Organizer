package interface_adapter.cooked;

import entity.Recipe;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_to_favorites.AddToFavoritesState;
import interface_adapter.add_to_favorites.AddToFavoritesViewModel;
import use_case.add_to_favorites.AddToFavoritesOutputBoundary;
import use_case.add_to_favorites.AddToFavoritesOutputData;
import use_case.cooked.CookedOutputBoundary;
import use_case.cooked.CookedOutputData;

public class CookedPresenter implements CookedOutputBoundary {
     private final CookedViewModel cookedViewModel;
     private final ViewManagerModel viewManagerModel;

     public CookedPresenter(CookedViewModel cookedViewModel, ViewManagerModel viewManagerModel) {
            this.cookedViewModel = cookedViewModel;
            this.viewManagerModel = viewManagerModel;
        }@Override
        public void prepareSuccessView(CookedOutputData outputData) {
            CookedState state = cookedViewModel.getState();
            state.setSetCookedSuccess(outputData.getSetCookedSuccess());
            cookedViewModel.setState(state);
            cookedViewModel.firePropertyChanged();
            viewManagerModel.setActiveView(cookedViewModel.getViewName());
            viewManagerModel.firePropertyChanged();
        }
    @Override
    public void prepareFailView(CookedOutputData outputData) {
        CookedState state = cookedViewModel.getState();
        state.setSetCookedSuccess(outputData.getSetCookedSuccess());
        cookedViewModel.setState(state);
        cookedViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(cookedViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
