package use_case.view_warehouse;

import entity.Recipe;
import interface_adapter.view_warehouse.ViewWarehousePresenter;

import java.util.List;

public class ViewWarehouseInteractor implements ViewWarehouseInputBoundary {
    // Data access interface and presenter
    private final ViewWarehouseDataAccessInterface viewWarehouseDataAccessInterface;
    private final ViewWarehousePresenter viewWarehousePresenter;

    // Constructor
    public ViewWarehouseInteractor(ViewWarehouseDataAccessInterface viewWarehouseDataAccessInterface, ViewWarehousePresenter viewWarehousePresenter) {
        this.viewWarehouseDataAccessInterface = viewWarehouseDataAccessInterface;
        this.viewWarehousePresenter = viewWarehousePresenter;
    }

    @Override
    public void execute() {
        List<Recipe> recipes = viewWarehouseDataAccessInterface.getAllRecipe();
        System.out.println("ViewWarehouseInteractor: " + recipes.size());
        ViewWarehouseOutputData viewWarehouseOutputData = new ViewWarehouseOutputData(recipes);
        viewWarehousePresenter.prepareSuccessView(viewWarehouseOutputData);
        // TODO: 当没有recipe时，是另外prepareFailure,还是直接返回空的list，然后显示空的list
    }
}
