package use_case.show_daily_special;

import entity.Recipe;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ShowDailySpecialOutputDataTest {
    @org.junit.jupiter.api.Test
    void testGetDailySpecialRecipe() {
        Recipe mockDailySpecialRecipe = mock(Recipe.class);
        ShowDailySpecialOutputData showDailySpecialOutputData = new ShowDailySpecialOutputData(mockDailySpecialRecipe);
        assertEquals(mockDailySpecialRecipe, showDailySpecialOutputData.getDailySpecialRecipe());
    }

}