package interface_adapter.open_create_recipe;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OpenCreateRecipeViewModel extends ViewModel{
    public OpenCreateRecipeViewModel() {
        super("edit recipe");
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("open", null, null);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
