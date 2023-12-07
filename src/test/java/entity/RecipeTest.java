package entity;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(true, recipe.getIsFavorite());
    }

    @Test
    void testGetIsCooked() {
        Recipe recipe = new Recipe(1, "Title", "Content", LocalDateTime.now(), true, false, 300.0);
        assertEquals(false, recipe.getIsCooked());
    }

    @Test
    void testGetCalories() {
        Recipe recipe = new Recipe(1, "Title", "Content", LocalDateTime.now(), true, false, 300.0);
        assertEquals(300.0, recipe.getCalories(), 0.001); // 添加 delta 以进行 double 比较
    }
}
