package use_case.add_to_favorites;

import entity.Recipe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddToFavoritesDataAccessInterfaceTest {

    private AddToFavoritesDataAccessInterface dao;
    private Recipe testRecipe;

    @BeforeEach
    void setUp() {
        dao = mock(AddToFavoritesDataAccessInterface.class);
        testRecipe = new Recipe(1, "Test Recipe", "Test Content", LocalDateTime.now(), false, false, 250.0);
    }

    @Test
    void getRecipeByTitle() {
        when(dao.getRecipeByTitle("Test Recipe")).thenReturn(testRecipe);

        Recipe retrievedRecipe = dao.getRecipeByTitle("Test Recipe");
        assertNotNull(retrievedRecipe);
        assertEquals("Test Recipe", retrievedRecipe.getTitle());
    }

    @Test
    void updateRecipe() throws Exception {
        doNothing().when(dao).updateRecipe(anyInt(), anyString(), anyString(), any(LocalDateTime.class), anyBoolean(), anyBoolean(), anyDouble());

        dao.updateRecipe(testRecipe.getId(), testRecipe.getTitle(), testRecipe.getContent(), testRecipe.getDate(), true, testRecipe.getIsCooked(), testRecipe.getCalories());

        ArgumentCaptor<Integer> idCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<String> titleCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> contentCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<LocalDateTime> dateCaptor = ArgumentCaptor.forClass(LocalDateTime.class);
        ArgumentCaptor<Boolean> isFavoriteCaptor = ArgumentCaptor.forClass(Boolean.class);
        ArgumentCaptor<Boolean> isCookedCaptor = ArgumentCaptor.forClass(Boolean.class);
        ArgumentCaptor<Double> caloriesCaptor = ArgumentCaptor.forClass(Double.class);

        verify(dao).updateRecipe(idCaptor.capture(), titleCaptor.capture(), contentCaptor.capture(), dateCaptor.capture(), isFavoriteCaptor.capture(), isCookedCaptor.capture(), caloriesCaptor.capture());

        assertEquals(testRecipe.getId(), idCaptor.getValue());
        assertEquals(testRecipe.getTitle(), titleCaptor.getValue());
        assertTrue(isFavoriteCaptor.getValue());
    }
}









