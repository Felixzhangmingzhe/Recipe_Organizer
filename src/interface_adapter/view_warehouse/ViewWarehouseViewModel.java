package interface_adapter.view_warehouse;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class ViewWarehouseViewModel extends ViewModel {
    public ViewWarehouseViewModel() {
        super("ViewWarehouseViewModel");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
