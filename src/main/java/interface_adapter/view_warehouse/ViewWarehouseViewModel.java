package interface_adapter.view_warehouse;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ViewWarehouseViewModel extends ViewModel {
    public final String TITLE_LABEL = "Recipe Warehouse";

    private ViewWarehouseState state = new ViewWarehouseState();
    public ViewWarehouseViewModel() {
        super("Warehouse View");
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
