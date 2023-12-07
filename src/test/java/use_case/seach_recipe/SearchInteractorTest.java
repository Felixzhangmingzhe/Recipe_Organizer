package use_case.seach_recipe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInteractorTest {
    @org.junit.jupiter.api.Test
    void testConstructor() {
        SearchInteractor actualSearchInteractor = new SearchInteractor();
        assertSame(actualSearchInteractor.getClass(), SearchInteractor.class);
    }

}