package interface_adapter.view_search;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ViewSearchViewModel extends ViewModel {

    private ViewSearchState state;

    public ViewSearchViewModel() {
        super("search");
    }

    public void setState(ViewSearchState state) {
        this.state = state;
    }


    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ViewSearchState getState() {
        return state;
    }
}
