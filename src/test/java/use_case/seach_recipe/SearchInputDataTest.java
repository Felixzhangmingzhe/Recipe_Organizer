package use_case.seach_recipe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInputDataTest {
    @org.junit.jupiter.api.Test
    void testConstructor() {
        SearchInputData actualSearchInputData = new SearchInputData();
        assertSame(actualSearchInputData.getClass(), SearchInputData.class);
    }

}