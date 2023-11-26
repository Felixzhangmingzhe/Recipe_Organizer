package interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchViewModel extends ViewModel {

    public final String TITLE_LABEL = "Search View";
    public final String SEARCH_BAR_LABEL = "enter xxx";

    public final String SIGNUP_BUTTON_LABEL = "Search";

//    private SignupState state = new SignupState();

    public SearchViewModel() {
        super("search");
    }

//    public void setState(SignupState state) {
//        this.state = state;
//    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

//    public SignupState getState() {
//        return state;
//    }
}
