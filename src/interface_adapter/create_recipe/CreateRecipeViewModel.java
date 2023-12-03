package interface_adapter.create_recipe;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateRecipeViewModel extends ViewModel {
    private CreateRecipeState state = new CreateRecipeState();
    public CreateRecipeViewModel() {super("Read Recipe");}
    public void setState(CreateRecipeState state) {
        this.state = state;
    }
    public CreateRecipeState getState() {
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
