package interface_adapter.view_favorites;

import entity.Recipe;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ViewFavoritesViewModel extends ViewModel {
    private List<Recipe> recipes;
    public ViewFavoritesViewModel() {
        super("viewFavoritesViewModel");// 名字怎么命名，命名了有什么用？
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    public List<Recipe> getRecipes() {
        return recipes;
    }
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("recipes", null, recipes);

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
