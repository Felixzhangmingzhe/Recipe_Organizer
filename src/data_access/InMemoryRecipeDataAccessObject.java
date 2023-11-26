//Class: InMemoryRecipeDataAccessObject
package data_access;

import entity.Recipe;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryRecipeDataAccessObject {
    private List<Recipe> recipes;

    public InMemoryRecipeDataAccessObject() {
        this.recipes = new ArrayList<>();
    }

    public List<Recipe> readRecipes() {
        return new ArrayList<>(recipes); // 返回副本，以防止外部修改内部数据
    }

    public void writeRecipes() {
        JSONArray jsonArray = new JSONArray();

        for (Recipe recipe : recipes) {
            JSONObject jsonRecipe = createJsonRecipe(recipe);
            jsonArray.put(jsonRecipe);
        }

        // 这里可以选择将 jsonArray 转换为字符串，或者直接存储 JSONArray 对象
        // 这里为了简化，直接打印 jsonArray
        System.out.println(jsonArray);
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    private Recipe parseRecipe(JSONObject jsonRecipe) {
        String title = jsonRecipe.getString("title");
        int id = jsonRecipe.getInt("id");
        String content = jsonRecipe.getString("content");
        LocalDateTime date = LocalDateTime.parse(jsonRecipe.getString("date"));
        boolean isFavorite = jsonRecipe.getBoolean("isFavorite");
        return new Recipe(id, title, content, date, isFavorite);
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
        InMemoryRecipeDataAccessObject dao = new InMemoryRecipeDataAccessObject();
        LocalDateTime Date = LocalDateTime.of(2021, 1, 1, 0, 0, 0);

        // Adding a recipe
        Recipe newRecipe = new Recipe(
                1,
                "Spaghetti Bolognese",
                "Cook the spaghetti. Cook the ground beef. Mix them together.",
                Date,
                false
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
