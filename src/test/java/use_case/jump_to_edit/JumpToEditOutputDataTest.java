package use_case.jump_to_edit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class JumpToEditOutputDataTest {

    private JumpToEditOutputData outputData;
    private LocalDateTime testDateTime;

    @BeforeEach
    void setUp() {
        testDateTime = LocalDateTime.now();
        outputData = new JumpToEditOutputData("Test Title", "Test Content", 1, true, 300.0, false, testDateTime);
    }

    @Test
    void getRecipeTitle() {
        assertEquals("Test Title", outputData.getRecipeTitle());
    }

    @Test
    void getRecipeContent() {
        assertEquals("Test Content", outputData.getRecipeContent());
    }

    @Test
    void getRecipeId() {
        assertEquals(1, outputData.getRecipeId());
    }

    @Test
    void getRecipeIsFavorite() {
        assertTrue(outputData.getRecipeIsFavorite());
    }

    @Test
    void getRecipeCalories() {
        assertEquals(300.0, outputData.getRecipeCalories());
    }

    @Test
    void getRecipeCooked() {
        assertFalse(outputData.getRecipeCooked());
    }

    @Test
    void getRecipeCreationTime() {
        assertEquals(testDateTime, outputData.getRecipeCreationTime());
    }
}
