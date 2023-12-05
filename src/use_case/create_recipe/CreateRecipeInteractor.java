package use_case.create_recipe;

// import Json
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import entity.Recipe;
import entity.RecipeFactory;

import java.io.IOException;

// import Chinese and English
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import java.time.LocalDateTime;

// import API
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CreateRecipeInteractor implements CreateRecipeInputBoundary{
    // Data access interface and presenter
    private final CreateRecipeUserDataAccessInterface createRecipeUserDataAccessInterface;
    private final CreateRecipeOutputBoundary createRecipePresenter;
    final RecipeFactory recipeFactory;

    // API token
    private static final String apiToken = "o2vhKjkn5tmz+/B9kpjD6Q==mOt0YRhnaodNiwxj";

    // Constructor
    public CreateRecipeInteractor(CreateRecipeOutputBoundary createRecipePresenter, CreateRecipeUserDataAccessInterface createRecipeUserDataAccessInterface, RecipeFactory recipeFactory) {
        this.createRecipePresenter = createRecipePresenter;
        this.createRecipeUserDataAccessInterface = createRecipeUserDataAccessInterface;
        this.recipeFactory = recipeFactory;
    }

    // Implementation of execute method in Input Boundary
    @Override
    public void execute(CreateRecipeInputData createRecipeInputData) {
        if (createRecipeInputData.getTitle().isEmpty()) {
            createRecipePresenter.prepareFailView("Title is empty");
        } else if (createRecipeInputData.getContent().isEmpty()) {
            createRecipePresenter.prepareFailView("Content is empty");
        } else if (createRecipeUserDataAccessInterface.existsByName(createRecipeInputData.getTitle())) {
            createRecipePresenter.prepareFailView("Recipe already exists");
        } else {
            // Create a new recipe
            int id = getNextRecipeId();
            LocalDateTime now = LocalDateTime.now();
            double calories = getCalsByName(createRecipeInputData.getTitle());
            Recipe recipe = recipeFactory.create(id, createRecipeInputData.getTitle(), createRecipeInputData.getContent(), now, false, calories, false);
            createRecipeUserDataAccessInterface.save(recipe);
            // Output the recipe to the view
            CreateRecipeOutputData createRecipeOutputData = new CreateRecipeOutputData(recipe.getId(), recipe.getTitle(), recipe.getContent(), recipe.getIsFavorite(), recipe.getCalories(), recipe.getDate());
            createRecipePresenter.prepareSuccessView(createRecipeOutputData);
        }
    }

    // Fetch calories data from API
    public static double fetchCaloriesData(String recipeName) throws IOException {
        URL url = new URL("https://api.api-ninjas.com/v1/nutrition?query=" + URLEncoder.encode(recipeName, StandardCharsets.UTF_8));

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("X-Api-Key" , apiToken);
        connection.setRequestProperty("Accept", "application/json");

        // Get response and calculate total calories
        try (InputStream responseStream = connection.getInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseStream);
            double totalCalories = 0.0;
            for(JsonNode node : root) {
                totalCalories += node.path("calories").asDouble();
            }
            return totalCalories;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Helper method to get calories by recipe title
    public static double getCalsByName(String title) {
        try {
            return fetchCaloriesData(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -2;  // If cannot fetch calories, return -1, and if calories is -1, then display "unknown" in view
    }

    // Helper method to get next recipe id
    private int getNextRecipeId() {
        int lastUsedId = createRecipeUserDataAccessInterface.getLastUsedRecipeIdFromDatabase();
        return lastUsedId + 1;
    }

    public static void main(String[] args) throws IOException {
        // Test calories fetching
        System.out.println("hello");
        System.out.println(getCalsByName("1lb brisket and fries"));
        System.out.println(fetchCaloriesData("1lb brisket and fries"));
        System.out.println(getCalsByName("pasta"));
        System.out.println(fetchCaloriesData("pasta"));
        System.out.println("hello");
    }
}
