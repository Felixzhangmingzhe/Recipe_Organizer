// Class: CreateRecipeInteractor
package use_case.create_recipe;

import com.fasterxml.jackson.databind.JsonNode;
import entity.Recipe;
import entity.RecipeFactory;

import java.io.IOException;
import java.time.LocalDateTime;

// import API
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
public class CreateRecipeInteractor implements CreateRecipeInputBoundary{
    final CreateRecipeOutputBoundary createRecipePresenter;
    final CreateRecipeUserDataAccessInterface createRecipeUserDataAccessInterface;
    private static final String apiToken = "gjpWnTK/4FKbbjdR40qx1Q==Mr2JvBrcJXuKu5aR";

    final RecipeFactory recipeFactory;
    public CreateRecipeInteractor(CreateRecipeOutputBoundary createRecipePresenter, CreateRecipeUserDataAccessInterface createRecipeUserDataAccessInterface, RecipeFactory recipeFactory) {
        this.createRecipePresenter = createRecipePresenter;
        this.createRecipeUserDataAccessInterface = createRecipeUserDataAccessInterface;
        this.recipeFactory = recipeFactory;
    }
    @Override
    public void execute(CreateRecipeInputData createRecipeInputData) {
        if (createRecipeInputData.getTitle().equals("")) {
            createRecipePresenter.prepareFailView("Title is empty");
        } else if (createRecipeInputData.getContent().equals("")) {
            createRecipePresenter.prepareFailView("Content is empty");}
        else if (createRecipeUserDataAccessInterface.existsByName(createRecipeInputData.getTitle())) {
            createRecipePresenter.prepareFailView("Recipe already exists");
        } else {
            int id = getNextRecipeId(); // Implement this method to get the next ID from the database
            LocalDateTime now = LocalDateTime.now();
            double calories = getCalsByName(createRecipeInputData.getTitle());
            Recipe recipe = recipeFactory.create(id, createRecipeInputData.getTitle(), createRecipeInputData.getContent(), now, false,calories);
            createRecipeUserDataAccessInterface.save(recipe);
            // Output the recipe to the view
            CreateRecipeOutputData createRecipeOutputData = new CreateRecipeOutputData(recipe.getId(),recipe.getTitle(), recipe.getContent(),recipe.getIsFavorite(), recipe.getCalories(), recipe.getDate());
            createRecipePresenter.prepareSuccessView(createRecipeOutputData);// 为啥菜谱会清空？
        }
    }
    public static double fetchCaloriesData(String recipeName) throws IOException {
        URL url = new URL("https://api.api-ninjas.com/v1/nutrition?query=%s".formatted(recipeName));

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("X-Api-Key" , apiToken);
        connection.setRequestProperty("Accept", "application/json");

        try (InputStream responseStream = connection.getInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseStream);
            return root.path("calories").asDouble();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }

    }

    public static double getCalsByName(String title) {
        try {
            return fetchCaloriesData(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -2;// 这样当calorie没有被找到时，就会返回-1，然后在之后显示的时候，遇到-1就会显示“未知”
    }

    private int getNextRecipeId() {
        int lastUsedId = createRecipeUserDataAccessInterface.getLastUsedRecipeIdFromDatabase();
        return lastUsedId + 1;
    }
    public static void main(String[] args) throws IOException {
        System.out.println("hello");
        System.out.println(getCalsByName("1lb brisket and fries"));
        System.out.println(fetchCaloriesData("1lb brisket and fries"));
        System.out.println("hello");
    }
}
