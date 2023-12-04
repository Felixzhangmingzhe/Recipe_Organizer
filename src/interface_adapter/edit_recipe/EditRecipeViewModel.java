package interface_adapter.edit_recipe;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EditRecipeViewModel extends ViewModel {
    private EditRecipeState state = new EditRecipeState();

    public EditRecipeViewModel() {
        super("Read Recipe");
    }

    public EditRecipeState getState() {
        return state;
    }

    public void setState(EditRecipeState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("edit", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
