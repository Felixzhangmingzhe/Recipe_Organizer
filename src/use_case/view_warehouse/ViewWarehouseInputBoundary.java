package use_case.view_warehouse;
import interface_adapter.view_warehouse.*;
public interface ViewWarehouseInputBoundary {
    private ViewWarehouseOutputBoundary viewWarehousePresenter;
    void execute();
}
