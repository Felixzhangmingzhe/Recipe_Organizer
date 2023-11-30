package view_test;

import org.junit.Before;
import org.junit.Test;
import view.RecipeView;

import static org.junit.Assert.*;

public class RecipeViewTest {

    private RecipeView recipeView;

    @Before
    public void setUp() {
        // Initialize RecipeView instance before each test
        recipeView = new RecipeView();
    }

    @Test
    public void testShowSearchPanel() {
        // Test the functionality of displaying the search panel
        recipeView.showSearchPanel();

        // Verify that the search panel is correctly displayed
        assertTrue("The search panel should be the currently displayed panel", recipeView.getContentPane().isAncestorOf(recipeView.searchPanel));
    }

    @Test
    public void testShowEditPanel() {
        // Test the functionality of displaying the edit panel
        recipeView.showEditPanel();

        // Verify that the edit panel is correctly displayed
        assertTrue("The edit panel should be the currently displayed panel", recipeView.getContentPane().isAncestorOf(recipeView.editPanel));
    }

    @Test
    public void testShowRecipePanel() {
        // Test the functionality of displaying the recipe panel
        recipeView.showRecipePanel();

        // Verify that the recipe panel is correctly displayed
        assertTrue("The recipe panel should be the currently displayed panel", recipeView.getContentPane().isAncestorOf(recipeView.recipePanel));
    }

    // Other potential tests...
}
