package use_case.view_warehouse;
import entity.Recipe;
import interface_adapter.view_warehouse.*;


import java.util.List;

public class ViewWarehouseInteractor implements ViewWarehouseInputBoundary{
    private ViewWarehousePresenter viewWarehousePresenter;
    private ViewWarehouseDataAccessInterface viewWarehouseDataAccessInterface;
    @Override
    public void execute() {
        List<Recipe> resipes = viewWarehouseDataAccessInterface.getAllRecipe();
        viewWarehousePresenter.present(viewWarehouseDataAccessInterface.getWarehouse());
    }
}
