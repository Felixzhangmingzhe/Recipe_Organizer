package entity;

import entity.Recipe;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    @Test
    void testGetId() {
        Recipe recipe = new Recipe(1, "Title", "Content", LocalDateTime.now(), true, false, 300.0);
        assertEquals(1, recipe.getId());
    }

    @Test
    void testGetTitle() {
        Recipe recipe = new Recipe(1, "Title", "Content", LocalDateTime.now(), true, false, 300.0);
        assertEquals("Title", recipe.getTitle());
    }

    @Test
    void testGetContent() {
        Recipe recipe = new Recipe(1, "Title", "Content", LocalDateTime.now(), true, false, 300.0);
        assertEquals("Content", recipe.getContent());
    }

    @Test
    void testGetDate() {
        LocalDateTime now = LocalDateTime.now();
        Recipe recipe = new Recipe(1, "Title", "Content", now, true, false, 300.0);
        assertEquals(now, recipe.getDate());
    }

    @Test
    void testGetIsFavorite() {
        Recipe recipe = new Recipe(1, "Title", "Content", LocalDateTime.now(), true, false, 300.0);
        assertTrue(recipe.getIsFavorite());
    }

    @Test
    void testGetIsCooked() {
        Recipe recipe = new Recipe(1, "Title", "Content", LocalDateTime.now(), true, false, 300.0);
        assertFalse(recipe.getIsCooked());
    }

    @Test
    void testGetCalories() {
        Recipe recipe = new Recipe(1, "Title", "Content", LocalDateTime.now(), true, false, 300.0);
        assertEquals(300.0, recipe.getCalories(), 0.001); // 添加 delta 以进行 double 比较
    }
}
