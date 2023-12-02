package interface_adapter.click_search;

import interface_adapter.ViewModel;
import interface_adapter.view_warehouse.ViewWarehouseViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ClickSearchViewModel extends ViewWarehouseViewModel {
    private ClickSearchState state;

    public ClickSearchViewModel() {
        super();
    }

    public void setState(ClickSearchState state) {
        this.state = state;
    }

    public ClickSearchState getState() {
        return state;
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

}
