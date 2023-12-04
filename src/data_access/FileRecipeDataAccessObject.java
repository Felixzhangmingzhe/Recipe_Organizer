// Class: FileRecipeDataAccessObject
package data_access;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Recipe;
import entity.RecipeFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import use_case.Back.BackDataAccessInterface;
import use_case.click_search.ClickSearchDataAccessInterface;
import use_case.cooked.CookedDataAccessInterface;
import use_case.create_recipe.CreateRecipeUserDataAccessInterface;
import use_case.edit_recipe.EditRecipeDataAccessInterface;
import use_case.jump_to_edit.JumpToEditDataAccessInterface;
import use_case.open_create_recipe.OpenCreateRecipeDataAccessInterface;
import use_case.show_daily_special.ShowDailySpecialDataAccessInterface;
import use_case.view_favorites.ViewFavoritesDataAccessInterface;
import use_case.add_to_favorites.AddToFavoritesDataAccessInterface;
import use_case.view_recipe.ViewRecipeDataAccessInterface;
import use_case.view_warehouse.ViewWarehouseDataAccessInterface;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
public class FileRecipeDataAccessObject implements CreateRecipeUserDataAccessInterface, ViewFavoritesDataAccessInterface,
        AddToFavoritesDataAccessInterface , ViewRecipeDataAccessInterface , ViewWarehouseDataAccessInterface,
        BackDataAccessInterface, JumpToEditDataAccessInterface, EditRecipeDataAccessInterface,
        OpenCreateRecipeDataAccessInterface, CookedDataAccessInterface, ShowDailySpecialDataAccessInterface, ClickSearchDataAccessInterface {
    private String filePath;

    private static final String apiToken = "o2vhKjkn5tmz+/B9kpjD6Q==mOt0YRhnaodNiwxj";

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
    public List<Recipe> readRecipesInFavorites() {
        List<Recipe> recipes = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(content);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonRecipe = jsonArray.getJSONObject(i);
                Recipe recipe = parseRecipe(jsonRecipe);
                if (recipe.getIsFavorite()) {
                    recipes.add(recipe);
                }
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
        boolean isFavorite = jsonRecipe.optBoolean("isFavorite");
        boolean isCooked = jsonRecipe.optBoolean("isCooked");
        double calories = jsonRecipe.optDouble("calories");
        return new Recipe(id, title, content, date, isFavorite, isCooked, calories);
    }
    // 下面的是写入的代码，但是当改变Recipe的属性时，上面的会报错，但下面的这个不报错，得自己加，注意啦！
    private JSONObject createJsonRecipe(Recipe recipe) {
        JSONObject jsonRecipe = new JSONObject();
        jsonRecipe.put("id", recipe.getId());
        jsonRecipe.put("title", recipe.getTitle());
        jsonRecipe.put("content", recipe.getContent());
        jsonRecipe.put("date", recipe.getDate().toString());// 这里时间变成了字符串
        jsonRecipe.put("isFavorite", recipe.getIsFavorite());
        jsonRecipe.put("isCooked", recipe.getIsCooked());
        jsonRecipe.put("calories", recipe.getCalories());
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
                Date,
                false,
                false,
                100
        );
        dao.addRecipe(newRecipe);

        // Reading all recipes
        List<Recipe> allRecipes = dao.readRecipes();
        for (Recipe recipe : allRecipes) {
            System.out.println(recipe);
        }
    }
    public boolean existsJudgingbyName(String identifier) {
        List<Recipe> recipes = readRecipes();
        for (Recipe recipe : recipes) {
            if (recipe.getTitle().equals(identifier)) {
                return true;
            }
        }
        return false;
    }
    public boolean existsJudgingbyId(int identifier) {
        List<Recipe> recipes = readRecipes();
        for (Recipe recipe : recipes) {
            if (recipe.getId() == identifier) {
                return true;
            }
        }
        return false;
    }
    public int getLastUsedRecipeId() {
        // 从数据库中读取最后一个菜谱的ID
        List<Recipe> recipes = readRecipes();
        int lastUsedId = 0;
        for (Recipe recipe : recipes) {
            if (recipe.getId() > lastUsedId) {
                lastUsedId = recipe.getId();
            }
        }
        return lastUsedId;
    }
    public Recipe getRecipeByName(String identifier) {
        List<Recipe> recipes = readRecipes();
        for (Recipe recipe : recipes) {
            if (recipe.getTitle().equals(identifier)) {
                return recipe;
            }
        }
        return null;
    }
    public void update(int id, String title, String content, LocalDateTime date, boolean isFavorite, boolean isCooked, double calories) {
        // 读取所有食谱
        List<Recipe> recipes = readRecipes();
        // 创建更新后的食谱列表
        List<Recipe> updatedRecipes = new ArrayList<>();

        for (Recipe recipe : recipes) {
            if (recipe.getId() == id) {
                // 创建新的食谱实例来替换旧的
                RecipeFactory recipeFactory = new RecipeFactory();
                Recipe updatedRecipe = recipeFactory.create(id, title, content, date, isFavorite,calories, isCooked);
                updatedRecipes.add(updatedRecipe);
            } else {
                updatedRecipes.add(recipe);
            }
        }

        // 将更新后的食谱列表写回文件
        writeRecipes(updatedRecipes);
    }

    // 以上是FileRecipeDataAccessObject的代码
    @Override
    public boolean existsByName(String identifier) {
        return existsJudgingbyName(identifier);
    }

    @Override
    public void save(Recipe recipe) {
        addRecipe(recipe);
    }//使用addRecipe方法来填充,这样不会覆盖

    @Override
    public int getLastUsedRecipeIdFromDatabase() {
        return getLastUsedRecipeId();
    }
    @Override
    public Recipe getRecipeById(int recipeId) {
        List<Recipe> recipes = readRecipes();
        for (Recipe recipe : recipes) {
            if (recipe.getId() == recipeId) {
                return recipe;
            }
        }
        return null;//如果没有找到，返回null,是这样吗，还是返回一个error String
    }

    @Override
    public Recipe getRecipeByTitle(String title) {
        List<Recipe> recipes = readRecipes();
        for (Recipe recipe : recipes) {
            if (recipe.getTitle().equals(title)) {
                return recipe;
            }
        }
        return null;
    }

    @Override
    public void updateRecipe(int id, String title, Object content, LocalDateTime date, boolean isFavorite, boolean isCooked, double calories) {
        update(id, title, (String) content, date, isFavorite, isCooked, calories);
    }


    @Override
    public List<Recipe> getFavorites() {
        return readRecipesInFavorites();
    }

    @Override
    public List<Recipe> getAllRecipe() {
        return readRecipes();
    }

    @Override
    public void updateRecipe(int id, String title, String content, LocalDateTime date, boolean isFavorite,boolean isCooked, double calories) {
        update(id, title, content, date, isFavorite, isCooked, calories);
    }

    @Override
    public Recipe getRecipeByRecipeTitle(String recipeTitle) {
        return getRecipeByName(recipeTitle);
    }

    @Override
    public void updateCookedRecipe(int id, String title, String content, LocalDateTime date, boolean isFavorite,boolean isCooked, double calories) {
        update(id, title, content, date, isFavorite, isCooked, calories);
    }

    @Override
    public Recipe getDailySpecial() throws IOException {
        String randomChar = "ABCDEFGHIJKLMNOPQXRSTUVWYZabcdefghijklmxnopqrstuvwyz";
        int randomInLetter = (int) Math.floor(Math.random()*randomChar.length());
        List<Recipe> recipes = getRecipesOnlyFromAPI(randomChar.substring(randomInLetter, randomInLetter+1));

        if (recipes!= null){
            int randomInRecipe = (int) Math.floor(Math.random()*recipes.size());
            Recipe recipe = recipes.get(randomInRecipe);
            addRecipe(recipe);
            return recipe;
        }
        return null;
    }

    private List<Recipe> getRecipesOnlyFromAPI(String substring) throws IOException {
        List<Recipe> resultRecipe = new ArrayList<>();

        URL url = new URL("https://api.api-ninjas.com/v1/recipe?query=" + URLEncoder.encode(substring, StandardCharsets.UTF_8));

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("X-Api-Key" , apiToken);
        connection.setRequestProperty("Accept", "application/json");

        try (InputStream responseStream = connection.getInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseStream);
            if (root.isArray()) {
                // 遍历前10个元素（如果它们存在）
                for (int i = 0; i < Math.min(root.size(), 5); i++) {
                    JsonNode recipe = root.get(i);
                    String recipeTitle = recipe.path("title").asText();
                    String recipeInstructions = recipe.path("instructions").asText();
                    Recipe newRecipe = new Recipe(getLastUsedRecipeIdFromDatabase() + 1, recipeTitle, recipeInstructions, LocalDateTime.now(), false, false,0);
                    resultRecipe.add(newRecipe);
                }
            }

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return resultRecipe;
    }

    @Override
    public boolean isRecipeExist(String title) {
        return getRecipeByTitle(title) != null;
    }

    @Override
    public List<Recipe> getRecipesFromAPI(String title) throws IOException {
        List<Recipe> resultRecipe = new ArrayList<>();
        List<Recipe> existRecipe = readRecipes();

        //先从数据库获取数据
        for (Recipe recipe: existRecipe){
            if (recipe.getTitle().contains(title)){
                resultRecipe.add(recipe);
            }
        }


        //再去API获取数据

        URL url = new URL("https://api.api-ninjas.com/v1/recipe?query=" + URLEncoder.encode(title, StandardCharsets.UTF_8));

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("X-Api-Key" , apiToken);
        connection.setRequestProperty("Accept", "application/json");

        try (InputStream responseStream = connection.getInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseStream);
            if (root.isArray()) {
                // 遍历前10个元素（如果它们存在）
                for (int i = 0; i < Math.min(root.size(), 10); i++) {
                    JsonNode recipe = root.get(i);
                    String recipeTitle = recipe.path("title").asText();
                    String recipeInstructions = recipe.path("instructions").asText();
                    Recipe newRecipe = new Recipe(getLastUsedRecipeIdFromDatabase() + 1, recipeTitle, recipeInstructions, LocalDateTime.now(), false, false,0);
                    resultRecipe.add(newRecipe);
                }
            }

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        //再去数据库获取数据
        //如果数据库中没有，就直接返回API的数据
        //如果数据库中有，就把API的数据和数据库的数据合并，返回

        for (Recipe recipe: resultRecipe){
//            System.out.println("这个是"+recipe.getTitle());
            if (isRecipeExist(recipe.getTitle())){ //如果API的数据在数据库中已经存在，就不加入数据库
//                System.out.println("存在");
                continue;
            }else { //如果API的数据在数据库中不存在，就加入数据库
//                System.out.println("不存在");
                addRecipe(recipe);
            }
        } //把API的数据加入数据库


        return resultRecipe;
    }

    @Override
    public int getNumOfCooked() {
        List<Recipe> recipes = readRecipes();
        int numOfCooked = 0;
        for (Recipe recipe : recipes) {
            if (recipe.getIsCooked()) {
                numOfCooked++;
            }
        }
        return numOfCooked;
    }
}