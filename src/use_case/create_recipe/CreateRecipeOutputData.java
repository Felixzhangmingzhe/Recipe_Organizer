package use_case.create_recipe;

public class CreateRecipeOutputData {
    private final String id;
    private final String title;
    private final String content;
    private boolean useCaseFailed;
    public CreateRecipeOutputData(String id, String title, String content, boolean useCaseFailed) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.useCaseFailed = useCaseFailed;
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
}
