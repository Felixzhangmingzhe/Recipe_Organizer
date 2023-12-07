package data_access;

import entity.Recipe;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FileRecipeDataAccessObjectTest {

    @Test
    public void testAddRecipeAndReadRecipes() throws JSONException {
        // 创建 FileRecipeDataAccessObject 实例
        FileRecipeDataAccessObject dao = new FileRecipeDataAccessObject("test_recipes.json");

        // 准备测试数据
        LocalDateTime date = LocalDateTime.now();
        Recipe newRecipe = new Recipe(
                1,
                "Test Recipe",
                "Test instructions",
                date,
                false,
                false,
                50.0
        );

        // 添加新食谱
        dao.addRecipe(newRecipe);

        // 读取所有食谱
        List<Recipe> recipes = dao.readRecipes();

        // 断言至少有一个食谱，并且第一个食谱的属性与添加的新食谱相匹配
        assertFalse(recipes.isEmpty());
        Recipe retrievedRecipe = recipes.get(0);
        assertEquals(newRecipe.getId(), retrievedRecipe.getId());
        assertEquals(newRecipe.getTitle(), retrievedRecipe.getTitle());
        assertEquals(newRecipe.getContent(), retrievedRecipe.getContent());
        assertEquals(newRecipe.getDate(), retrievedRecipe.getDate());
        assertEquals(newRecipe.getIsFavorite(), retrievedRecipe.getIsFavorite());
        assertEquals(newRecipe.getCalories(), retrievedRecipe.getCalories(), 0.001); // 使用 delta 处理 double 的比较
        assertEquals(newRecipe.getIsCooked(), retrievedRecipe.getIsCooked());
    }

    @Test
    public void testReadRecipesInFavorites() throws JSONException {
        // 创建 FileRecipeDataAccessObject 实例
        FileRecipeDataAccessObject dao = new FileRecipeDataAccessObject("test_recipes.json");

        // 准备测试数据
        LocalDateTime date = LocalDateTime.now();
        Recipe favoriteRecipe = new Recipe(
                2,
                "Favorite Recipe",
                "Favorite instructions",
                date,
                true,
                false,
                75.0
        );

        // 添加收藏食谱
        dao.addRecipe(favoriteRecipe);

        // 读取收藏食谱
        List<Recipe> favoriteRecipes = dao.readRecipesInFavorites();

        // 断言至少有一个收藏食谱，并且第一个食谱的属性与添加的新食谱相匹配
        assertFalse(favoriteRecipes.isEmpty());
        Recipe retrievedFavoriteRecipe = favoriteRecipes.get(0);
        assertEquals(favoriteRecipe.getId(), retrievedFavoriteRecipe.getId());
        assertEquals(favoriteRecipe.getTitle(), retrievedFavoriteRecipe.getTitle());
        assertEquals(favoriteRecipe.getContent(), retrievedFavoriteRecipe.getContent());
        assertEquals(favoriteRecipe.getDate(), retrievedFavoriteRecipe.getDate());
        assertEquals(favoriteRecipe.getIsFavorite(), retrievedFavoriteRecipe.getIsFavorite());
        assertEquals(favoriteRecipe.getCalories(), retrievedFavoriteRecipe.getCalories(), 0.001); // 使用 delta 处理 double 的比较
        assertEquals(favoriteRecipe.getIsCooked(), retrievedFavoriteRecipe.getIsCooked());
    }

    // 可以添加其他测试方法...

}
