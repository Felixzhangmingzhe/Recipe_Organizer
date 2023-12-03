package entity;

import entity.Recipe;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;
import static org.junit.Assert.*;

public class RecipeTest {
    private Recipe recipe;
    private int id;
    private String title;
    private String content;
    private LocalDateTime date;
    private boolean isFavorite;
    private boolean isCooked;
    private double calories;

    @Before
    public void setUp() {
        // 初始化测试数据
        id = 1;
        title = "测试食谱";
        content = "这是食谱内容。";
        date = LocalDateTime.now();
        isFavorite = true;
        isCooked = false;
        calories = 250;

        // 创建Recipe对象
        recipe = new Recipe(id, title, content, date, isFavorite, isCooked, calories);
    }

    @Test
    public void testRecipeConstructorAndGetters() {
        // 验证Recipe构造器是否正确设置了属性
        assertEquals("ID应该匹配", id, recipe.getId());
        assertEquals("标题应该匹配", title, recipe.getTitle());
        assertEquals("内容应该匹配", content, recipe.getContent());
        assertEquals("日期应该匹配", date, recipe.getDate());
        assertEquals("是否收藏应该匹配", isFavorite, recipe.getIsFavorite());
        assertEquals("是否烹饪过应该匹配", isCooked, recipe.getIsCooked());
        assertEquals("卡路里应该匹配", calories, recipe.getCalories(), 0.0);
    }

    // 其他测试方法...
}
