package view_test;

import org.junit.Before;
import org.junit.Test;
import view.FavoritesView;

import static org.junit.Assert.*;

public class FavoritesViewTest {

    private FavoritesView favoritesView;

    @Before
    public void setUp() {
        // 初始化 FavoritesView 实例
        favoritesView = new FavoritesView();
    }

    @Test

    public void testTotalFavoritesPanelNotNull() {
        // 检查 TotalFavoritesPanel 是否被正确初始化
        assertNotNull("TotalFavoritesPanel 不应为 null", favoritesView.getTotalfavoritesPanel());
    }

    @Test
    public void testFavoritesPanelNotNull() {
        // 检查 FavoritesPanel 是否被正确初始化
        assertNotNull("FavoritesPanel 不应为 null", favoritesView.getFavoritesPanel());
    }

    // 测试 showTotalFavorites 和 showSingleFolder 方法
    // 这里的测试可能需要根据实际的 GUI 行为进行调整
    // 由于这些方法涉及到显示 JFrame，可能需要特定的策略来测试 GUI 行为

}
