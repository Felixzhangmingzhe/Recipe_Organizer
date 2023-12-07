package entity;


import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class RecipeFactoryTest {

    @Test
    public void testCreateRecipe() {
        // 创建 RecipeFactory 实例
        RecipeFactory recipeFactory = new RecipeFactory();

        // 创建测试数据
        int id = 1;
        String title = "Test Recipe";
        String content = "Test instructions";
        LocalDateTime date = LocalDateTime.now();
        boolean isFavorite = true;
        double calories = 50.0;
        boolean isCooked = false;

        // 使用 RecipeFactory 创建 Recipe 实例
        Recipe recipe = recipeFactory.create(id, title, content, date, isFavorite, calories, isCooked);

        // 断言 Recipe 实例的属性与预期值相匹配
        assertEquals(id, recipe.getId());
        assertEquals(title, recipe.getTitle());
        assertEquals(content, recipe.getContent());
        assertEquals(date, recipe.getDate());
        assertEquals(isFavorite, recipe.getIsFavorite());
        assertEquals(calories, recipe.getCalories(), 0.001); // 使用 delta 处理 double 的比较
        assertEquals(isCooked, recipe.getIsCooked());
    }

    // 可以添加其他测试方法...

}
