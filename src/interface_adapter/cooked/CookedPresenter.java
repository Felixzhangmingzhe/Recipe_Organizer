package interface_adapter.cooked;

import entity.Recipe;
import interface_adapter.ViewManagerModel;
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
