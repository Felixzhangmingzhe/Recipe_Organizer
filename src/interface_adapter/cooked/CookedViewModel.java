package interface_adapter.cooked;
import interface_adapter.ViewModel;
import interface_adapter.add_to_favorites.AddToFavoritesState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
public class CookedViewModel extends ViewModel {
    private CookedState state = new CookedState();

    public CookedViewModel() {
        super("Read Recipe");
    }

    public CookedState getState() {
        return state;
    }
    public void setState(CookedState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("cooked", null, state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
