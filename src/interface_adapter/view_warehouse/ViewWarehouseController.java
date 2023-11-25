package interface_adapter.view_warehouse;

import use_case.view_warehouse.ViewWarehouseInputBoundary;

public class ViewWarehouseController {
    final ViewWarehouseInputBoundary viewWarehouseInteractor;

    public ViewWarehouseController(ViewWarehouseInputBoundary viewWarehouseInteractor) {
        this.viewWarehouseInteractor = viewWarehouseInteractor;
    }
    public void execute() {
        viewWarehouseInteractor.execute();
    }
}
