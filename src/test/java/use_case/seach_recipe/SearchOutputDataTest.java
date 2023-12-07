package use_case.seach_recipe;

import static org.junit.jupiter.api.Assertions.*;

class SearchOutputDataTest {
    @org.junit.jupiter.api.Test
    void testConstructor() {
        SearchOutputData actualSearchOutputData = new SearchOutputData();
        assertSame(actualSearchOutputData.getClass(), SearchOutputData.class);
    }

}