package interface_adapter.view_recipe;

import entity.Recipe;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ViewRecipeViewModel extends ViewModel {

    private Recipe recipe;

    public ViewRecipeViewModel() {
        super("Recipe View");
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    public Recipe getRecipe() {
        return recipe;
    }
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("recipe", null, recipe);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
