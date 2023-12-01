package interface_adapter.view_recipe;

import entity.Recipe;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDateTime;

public class ViewRecipeViewModel extends ViewModel {

    private String title;
    private String content;
    private LocalDateTime creationTime;
    private double calories;
    private String noRecipeFoundMessage;

    public ViewRecipeViewModel() {
        super("Read Recipe");
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
    public LocalDateTime getCreationTime() {
        return creationTime;
    }
    public void setCalories(double calories) {
        this.calories = calories;
    }
    public double getCalories() {
        return calories;
    }

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("recipe", null, this);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }



    public void setNoRecipeFoundMessage(String errorMessage) {
        this.noRecipeFoundMessage = errorMessage;
    }
    public String getNoRecipeFoundMessage() {
        return noRecipeFoundMessage;
    }
}
