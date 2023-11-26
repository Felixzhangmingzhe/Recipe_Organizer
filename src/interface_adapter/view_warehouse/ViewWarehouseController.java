package interface_adapter.view_warehouse;

import use_case.view_warehouse.ViewWarehouseDataAccessInterface;
import use_case.view_warehouse.ViewWarehouseInputBoundary;

public class ViewWarehouseController {
    final ViewWarehouseInputBoundary viewWarehouseInteractor;
    final ViewWarehouseDataAccessInterface viewWarehouseDataAccessInterface;

    public ViewWarehouseController(ViewWarehouseInputBoundary viewWarehouseInteractor, ViewWarehouseDataAccessInterface viewWarehouseDataAccessInterface) {
        this.viewWarehouseInteractor = viewWarehouseInteractor;
        this.viewWarehouseDataAccessInterface = viewWarehouseDataAccessInterface;
    }
    public void execute() {
        viewWarehouseInteractor.execute();
    }
}
