package view_test;

import interface_adapter.view_recipe.ViewRecipeController;
import org.junit.Before;
import org.junit.Test;
import view.WarehouseView;

import javax.swing.*;
import static org.junit.Assert.*;

public class WarehouseViewTest {

    private WarehouseView warehouseView;

    @Before
    public void setUp() {
        // 创建 ViewRecipeController 的存根
        // 存根方法的实现，可以根据需要添加逻辑
        ViewRecipeController mockViewRecipeController = new ViewRecipeController() {
            @Override
            public void execute(int recipeId) {
                // 存根方法的实现，可以根据需要添加逻辑
            }
        };

        // 初始化 WarehouseView 实例
        warehouseView = new WarehouseView(mockViewRecipeController);
    }


    @Test
    public void testWarehousePanelNotNull() {
        // 测试 WarehousePanel 是否正确初始化
        assertNotNull("WarehousePanel should not be null", warehouseView.getWarehousePanel());
    }



}
