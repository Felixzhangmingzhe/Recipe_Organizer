package interface_adapter.open_create_recipe;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class OpenCreateRecipeViewModel extends ViewModel{
    public OpenCreateRecipeViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
