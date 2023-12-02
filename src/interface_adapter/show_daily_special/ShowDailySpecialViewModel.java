package interface_adapter.show_daily_special;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ShowDailySpecialViewModel extends ViewModel {

    private ShowDailySpecialState state;

    public ShowDailySpecialViewModel() {
        super("Daily Special");
    }

    public void setState(ShowDailySpecialState state) {
        this.state = state;
    }

    public ShowDailySpecialState getState() {
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
