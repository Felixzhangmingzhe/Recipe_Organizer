package interface_adapter.show_daily_special;

import java.time.LocalDateTime;

public class ShowDailySpecialState {
    private String title;
    private String content;
    private LocalDateTime creationTime;
    private double calories;


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
}
