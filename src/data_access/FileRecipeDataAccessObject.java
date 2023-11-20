// Class: FileRecipeDataAccessObject
package data_access;
import entity.Recipe;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
public class FileRecipeDataAccessObject {
    private String filePath;

    public FileRecipeDataAccessObject(String filePath) {
        this.filePath = filePath;
    }

    public List<Recipe> readRecipes() {
        List<Recipe> recipes = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(content);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonRecipe = jsonArray.getJSONObject(i);
                Recipe recipe = parseRecipe(jsonRecipe);
                recipes.add(recipe);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return recipes;
    }
    public void writeRecipe(Recipe recipe) {
        JSONObject jsonRecipe = createJsonRecipe(recipe);

        try {
            Files.write(Paths.get(filePath), jsonRecipe.toString(2).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeRecipes(List<Recipe> recipes) {
        JSONArray jsonArray = new JSONArray();

        for (Recipe recipe : recipes) {
            JSONObject jsonRecipe = createJsonRecipe(recipe);
            jsonArray.put(jsonRecipe);
        }

        try {
            Files.write(Paths.get(filePath), jsonArray.toString(2).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addRecipe(Recipe recipe) {
        List<Recipe> recipes = readRecipes();
        recipes.add(recipe);
        writeRecipes(recipes);
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

    public static void main(String[] args) {
        FileRecipeDataAccessObject dao = new FileRecipeDataAccessObject("recipes.json");
        LocalDateTime Date = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
        // Adding a recipe
        Recipe newRecipe = new Recipe(
                1,
                "Spaghetti Bolognese",
                "Cook the spaghetti. Cook the ground beef. Mix them together.",
                Date
        );
        dao.addRecipe(newRecipe);

        // Reading all recipes
        List<Recipe> allRecipes = dao.readRecipes();
        for (Recipe recipe : allRecipes) {
            System.out.println(recipe);
        }
    }
}