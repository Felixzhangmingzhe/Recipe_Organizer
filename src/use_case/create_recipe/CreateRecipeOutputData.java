package use_case.create_recipe;

public class CreateRecipeOutputData {
    private final String id;
    private final String title;
    private final String content;
    private final boolean isFavorite;
    private final double calories;

    public CreateRecipeOutputData(String id, String title, String content, boolean isFavorite, double calories) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isFavorite = isFavorite;
        this.calories = calories;

    }
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public boolean getisFavorite() {
        return isFavorite;
    }
    public double getCalories() {
        return calories;
    }

}
