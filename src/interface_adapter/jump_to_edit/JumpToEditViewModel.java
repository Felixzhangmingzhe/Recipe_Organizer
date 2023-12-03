package interface_adapter.jump_to_edit;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class JumpToEditViewModel extends ViewModel {
    private JumpToEditState state = new JumpToEditState();
    public JumpToEditViewModel() { super("edit recipe"); }
    public void setState(JumpToEditState state) {
        this.state = state;
    }
    public JumpToEditState getState() {
        return state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("edit", null, state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
