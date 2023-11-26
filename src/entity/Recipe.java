package entity;

import java.time.LocalDateTime;

public class Recipe {
    private int id;
    private String title;
    private String content;
    private boolean isFavorite;

    private LocalDateTime date;
    public Recipe(int id, String title, String content, LocalDateTime date, boolean isFavorite) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.isFavorite = isFavorite;
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
}