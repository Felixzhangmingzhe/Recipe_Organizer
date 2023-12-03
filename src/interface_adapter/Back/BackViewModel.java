package interface_adapter.Back;

import interface_adapter.ViewModel;
import use_case.Back.BackState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BackViewModel extends ViewModel {
    private BackState state = new BackState();

    public BackViewModel() {
        super("Initial Interface");
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
