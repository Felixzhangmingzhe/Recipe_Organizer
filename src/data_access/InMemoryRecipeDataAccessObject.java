//Class: InMemoryRecipeDataAccessObject
package data_access;

import entity.Recipe;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Class: InMemoryRecipeDataAccessObject
public class InMemoryRecipeDataAccessObject {
    private List<Recipe> recipes;
    private int lastUsedId; // Track the last used ID

    public InMemoryRecipeDataAccessObject() {
        this.recipes = new ArrayList<>();
        this.lastUsedId = 0; // Initialize the last used ID
    }

    public List<Recipe> readRecipes() {
        return new ArrayList<>(recipes); // Return a copy to prevent external modifications
    }

    public void writeRecipes() {
        JSONArray jsonArray = new JSONArray();

        for (Recipe recipe : recipes) {
            JSONObject jsonRecipe = createJsonRecipe(recipe);
            jsonArray.put(jsonRecipe);
        }

        System.out.println(jsonArray); // For simplicity, you can print the JSON array
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        lastUsedId = recipe.getId(); // Update the last used ID when adding a new recipe
    }

    private Recipe parseRecipe(JSONObject jsonRecipe) {
        String title = jsonRecipe.getString("title");
        int id = jsonRecipe.getInt("id");
        String content = jsonRecipe.getString("content");
        LocalDateTime date = LocalDateTime.parse(jsonRecipe.getString("date"));
        return new Recipe(id, title, content, date);
    }

    private JSONObject createJsonRecipe(Recipe recipe) {
        JSONObject jsonRecipe = new JSONObject();
        jsonRecipe.put("id", recipe.getId());
        jsonRecipe.put("title", recipe.getTitle());
        jsonRecipe.put("content", recipe.getContent());
        jsonRecipe.put("date", recipe.getDate().toString());
        return jsonRecipe;
    }

    public int getLastUsedId() {
        return lastUsedId;
    }

    public static void main(String[] args) {
        InMemoryRecipeDataAccessObject dao = new InMemoryRecipeDataAccessObject();
        LocalDateTime Date = LocalDateTime.of(2021, 1, 1, 0, 0, 0);

        // Adding a recipe
        Recipe newRecipe = new Recipe(
                dao.getLastUsedId() + 1, // Use the next available ID
                "Spaghetti Bolognese",
                "Cook the spaghetti. Cook the ground beef. Mix them together.",
                Date
        );
        dao.addRecipe(newRecipe);

        // Writing recipes to JSON
        dao.writeRecipes();

        // Reading all recipes
        List<Recipe> allRecipes = dao.readRecipes();
        for (Recipe recipe : allRecipes) {
            System.out.println(recipe);
        }
    }
}
