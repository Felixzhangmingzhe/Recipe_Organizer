package interface_adapter.view_search;

import entity.Recipe;
import interface_adapter.ViewModel;
import interface_adapter.view_search.ViewSearchState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ViewSearchViewModel extends ViewModel {

    private ViewSearchState state;

    public ViewSearchViewModel() {
        super("search");
    }

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
//        support.firePropertyChange();
        //不太确定怎么change
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ViewSearchState getState() {
        return state;
    }
}
