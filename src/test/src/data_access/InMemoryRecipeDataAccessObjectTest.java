//package data_access;
//
//import entity.Recipe;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//public class InMemoryRecipeDataAccessObjectTest {
//    private InMemoryRecipeDataAccessObject dao;
//    private Recipe testRecipe;
//
//    @Before
//    public void setUp() {
//        dao = new InMemoryRecipeDataAccessObject();
//        LocalDateTime testDate = LocalDateTime.of(2021, 1, 1, 0, 0);
//        testRecipe = new Recipe(1, "Test Spaghetti", "Test Description", testDate, false, false, 500);
//    }
//
//    @Test
//    public void testAddAndReadRecipes() {
//        dao.addRecipe(testRecipe);
//        List<Recipe> recipes = dao.readRecipes();
//
//        assertEquals("应该只有一个食谱", 1, recipes.size());
//        Recipe retrievedRecipe = recipes.get(0);
//
//        assertEquals("食谱 ID 应该相等", testRecipe.getId(), retrievedRecipe.getId());
//        assertEquals("食谱标题应该相等", testRecipe.getTitle(), retrievedRecipe.getTitle());
//        assertEquals("食谱内容应该相等", testRecipe.getContent(), retrievedRecipe.getContent());
//        assertEquals("食谱日期应该相等", testRecipe.getDate(), retrievedRecipe.getDate());
//        assertEquals("是否收藏应该相等", testRecipe.getIsFavorite(), retrievedRecipe.getIsFavorite());
//        assertEquals("是否烹饪过应该相等", testRecipe.getIsCooked(), retrievedRecipe.getIsCooked());
//        assertEquals("卡路里应该相等", testRecipe.getCalories(), retrievedRecipe.getCalories(), 0.0);
//    }
//
//    // 根据需要添加更多测试方法...
//}
