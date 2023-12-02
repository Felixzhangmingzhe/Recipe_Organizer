package view_test;

import interface_adapter.ViewManagerModel;
import org.junit.Before;
import org.junit.Test;
import view.MainView;

import interface_adapter.view_warehouse.*;
import interface_adapter.view_favorites.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.Assert.*;

public class MainViewTest {


    private MainView mainView;

    // 在每个测试之前执行的设置方法

    @Before
    public void setUp() {
        // 假设 MainView 可以在不需要额外依赖的情况下初始化
        ViewWarehouseController stubWarehouseController = new ViewWarehouseController(null);
        ViewWarehouseViewModel stubWarehouseViewModel = new ViewWarehouseViewModel();
        ViewFavoritesController stubFavoritesController = new ViewFavoritesController(null);
        ViewFavoritesViewModel stubFavoritesViewModel = new ViewFavoritesViewModel();
        ViewManagerModel stubViewManagerModel = new ViewManagerModel() {
            // 实现必要的方法
        };

        // 创建 MainView 实例
        mainView = new MainView(stubWarehouseController, stubWarehouseViewModel, stubFavoritesController, stubFavoritesViewModel, stubViewManagerModel);
    }


    // 测试 MainView 是否正确初始化了
    // 但是这些都是private啊
    // 但是这些按钮又感觉测试一下很有必要
    @Test
    public void testComponentInitialization() {
        assertNotNull("Create Recipe button should not be null", mainView.createRecipe);
        assertNotNull("Daily Special button should not be null", mainView.dailySpecial);
        assertNotNull("Favorites button should not be null", mainView.favorites);
        assertNotNull("Exit button should not be null", mainView.exit);
        assertNotNull("All Recipes button should not be null", mainView.allRecipes);
    }

    // 测试添加到创建菜谱按钮的动作监听器是否正确响应
    @Test
    public void testCreateRecipeButtonActionListener() {
        // 创建一个标志来检测动作监听器是否被正确调用
        final boolean[] listenerInvoked = {false};

        // 添加测试用的动作监听器
        mainView.addRecipeButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listenerInvoked[0] = true;
            }
        });

        // 模拟按钮点击
        mainView.createRecipe.doClick();

        // 确认监听器被调用
        assertTrue("点击创建菜谱按钮时，应该调用相应的监听器", listenerInvoked[0]);
    }

    // 以此类推，您可以为其他按钮添加类似的测试
}
