package entity;


public class Recipe {
    private int id;
    private String title;
    private String content;
    Recipe(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
