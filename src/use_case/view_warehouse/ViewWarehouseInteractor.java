package use_case.view_warehouse;
import entity.Recipe;
import interface_adapter.view_warehouse.*;


import java.util.List;

public class ViewWarehouseInteractor implements ViewWarehouseInputBoundary{
    private ViewWarehousePresenter viewWarehousePresenter;
    private ViewWarehouseDataAccessInterface viewWarehouseDataAccessInterface;
    public ViewWarehouseInteractor(ViewWarehousePresenter viewWarehousePresenter, ViewWarehouseDataAccessInterface viewWarehouseDataAccessInterface) {
        this.viewWarehousePresenter = viewWarehousePresenter;
        this.viewWarehouseDataAccessInterface = viewWarehouseDataAccessInterface;
    }
    @Override
    public void execute() {//当没有recipe时，是另外prepareFailure,还是直接返回空的list，然后显示空的list
        List<Recipe> resipes = viewWarehouseDataAccessInterface.getAllRecipe();
        System.out.println("ViewWarehouseInteractor: " + resipes.size());// Trace the execution, Ensure this program execute.
        ViewWarehouseOutputData viewWarehouseOutputData = new ViewWarehouseOutputData(resipes);
        viewWarehousePresenter.prepareSuccessView(viewWarehouseOutputData);
    }
}
