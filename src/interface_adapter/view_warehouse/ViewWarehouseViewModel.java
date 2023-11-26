package interface_adapter.view_warehouse;

import interface_adapter.ViewModel;
import use_case.view_warehouse.ViewWarehouseState;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ViewWarehouseViewModel extends ViewModel {
    private ViewWarehouseState state = new ViewWarehouseState();
    public ViewWarehouseViewModel() {
        super("ViewWarehouseViewModel");
    }
    public void setState(ViewWarehouseState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ViewWarehouseState getState() {
        return state;
    }
}
