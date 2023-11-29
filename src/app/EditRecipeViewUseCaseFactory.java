package app;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackPresenter;
import interface_adapter.Back.BackViewModel;
import interface_adapter.ViewManagerModel;
import use_case.Back.BackInputBoundary;
import use_case.Back.BackInteractor;
import use_case.Back.BackOutputBoundary;
import view.EditRecipeView;

public class EditRecipeViewUseCaseFactory {
    public static EditRecipeView create(BackViewModel backViewModel,ViewManagerModel viewManagerModel) {
        BackController backController = createBackController(backViewModel, viewManagerModel);
        return new EditRecipeView(backController, backViewModel);
    }
    public static BackController createBackController(BackViewModel backViewModel, ViewManagerModel viewManagerModel) {
        BackOutputBoundary backOutputBoundary = new BackPresenter(viewManagerModel, backViewModel);
        BackInputBoundary backInputBoundary = new BackInteractor(backOutputBoundary);
        return new BackController(backInputBoundary);
    }
}
