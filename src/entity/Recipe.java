package entity;

import java.time.LocalDateTime;

public class Recipe {
    private int id;
    private String title;
    private String content;
    private boolean isFavorite;
    private double calories;

    private LocalDateTime date;
    public Recipe(int id, String title, String content, LocalDateTime date, boolean isFavorite, double calories) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.isFavorite = isFavorite;
        this.calories = calories;
    }
    public int getId() {
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }
    public String getContent() {
        return this.content;
    }
    public LocalDateTime getDate() {
        return this.date;
    }

    public boolean getIsFavorite() {
        return this.isFavorite;
    }

    public double getCalories() {return this.calories;}

    public LocalDateTime getCreationTime() {
        return this.date;
    }

}