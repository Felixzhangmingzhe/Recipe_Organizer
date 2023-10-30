package use_case.create_recipe;

public class CreateRecipeInputData {
    final private String title;
    final private String content;
    public CreateRecipeInputData(String title, String content) {

        this.title = title;
        this.content = content;

    }

    String getTitle() {
        return title;
    }
    String getContent() {
        return content;
    }
}
