package interface_adapter.jump_to_edit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class JumpToEditStateTest {

    private JumpToEditState state;
    private LocalDateTime testDateTime;

    @BeforeEach
    void setUp() {
        state = new JumpToEditState();
        testDateTime = LocalDateTime.now();
    }

    @Test
    void getAndSetRecipeTitle() {
        String title = "Test Title";
        state.setRecipeTitle(title);
        assertEquals(title, state.getRecipeTitle());
    }

    @Test
    void getAndSetRecipeContent() {
        String content = "Test Content";
        state.setRecipeContent(content);
        assertEquals(content, state.getRecipeContent());
    }

    @Test
    void getAndSetRecipeId() {
        int id = 1;
        state.setRecipeId(id);
        assertEquals(id, state.getRecipeId());
    }

    @Test
    void getAndSetRecipeIsFavorite() {
        state.setRecipeIsFavorite(true);
        assertTrue(state.getRecipeIsFavorite());
    }

    @Test
    void getAndSetRecipeCalories() {
        double calories = 250.0;
        state.setRecipeCalories(calories);
        assertEquals(calories, state.getRecipeCalories());
    }

    @Test
    void getAndSetRecipeCooked() {
        state.setRecipeCooked(true);
        assertTrue(state.getRecipeCooked());
    }

    @Test
    void getAndSetRecipeCreationTime() {
        state.setRecipeCreationTime(testDateTime);
        assertEquals(testDateTime, state.getRecipeCreationTime());
    }
}
