package use_case.view_recipe;

import entity.Recipe;

import java.time.LocalDateTime;

public class ViewRecipeOutputData {
    private final String title;
    private final String content;
    private final LocalDateTime creationTime;
    private final double calories;


    public ViewRecipeOutputData(String title, String content, LocalDateTime creationTime, double calories) {
        this.title = title;
        this.content = content;
        this.creationTime = creationTime;
        this.calories = calories;
    }

    public String getTitle() {
        return title;}
    public String getContent() {
        return content;}

    public LocalDateTime getCreationTime() {
        return creationTime;}

    public double getCalories() {
        return calories;
    }

}