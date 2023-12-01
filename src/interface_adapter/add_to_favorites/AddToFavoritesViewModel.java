package interface_adapter.add_to_favorites;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddToFavoritesViewModel extends ViewModel {
    private AddToFavoritesState state = new AddToFavoritesState();

    public AddToFavoritesViewModel() {
        super("Read Recipe");
    }
    public AddToFavoritesState getState() {
        return state;
    }
    public void setState(AddToFavoritesState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
