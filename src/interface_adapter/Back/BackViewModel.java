package interface_adapter.Back;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BackViewModel extends ViewModel {
    private BackState state = new BackState();
    public BackState getState() {
        return state;
    }
    public void setState(BackState state) {
        this.state = state;
    }

    public BackViewModel() {
        super("Initial Interface");
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("back", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }


}
