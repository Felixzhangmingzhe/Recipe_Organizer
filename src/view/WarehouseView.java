package view;

import entity.Recipe;
import interface_adapter.Back.BackController;
import interface_adapter.ViewManagerModel;
import interface_adapter.view_recipe.ViewRecipeController;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import interface_adapter.view_warehouse.ViewWarehouseState;
import interface_adapter.view_warehouse.ViewWarehouseViewModel;
import org.json.JSONArray;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class WarehouseView extends JPanel implements ActionListener, PropertyChangeListener {
    public static final String viewName = "Warehouse View";

    private final ViewRecipeController viewRecipeController;
    JList<String> RecipeList; // 创建菜谱列表
    JScrollPane scrollPane;
    private List<Recipe> recipes;
    JButton back; // 创建菜谱按钮
    private final ViewRecipeViewModel viewRecipeViewModel;

    private final BackController backController;
    private final ViewManagerModel viewManagerModel;
    private final ViewWarehouseViewModel viewWarehouseViewModel;

    private JPanel WarehousePanel = new JPanel();

    public WarehouseView(ViewRecipeController viewRecipeController, ViewRecipeViewModel viewRecipeViewModel,
                         BackController backController,
                         ViewWarehouseViewModel viewWarehouseViewModel,
                         ViewManagerModel viewManagerModel) {
        JLabel title = new JLabel("Recipe Warehouse");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.viewRecipeViewModel = viewRecipeViewModel;
        this.viewRecipeController = viewRecipeController;
        this.backController = backController;
        this.viewManagerModel = viewManagerModel;
        this.viewWarehouseViewModel = viewWarehouseViewModel;
        this.viewWarehouseViewModel.addPropertyChangeListener(this);


        // 初始化界面元素
        WarehousePanel.setLayout(new BorderLayout());
        WarehousePanel.setPreferredSize(new Dimension(600, 400));
        WarehousePanel.setBackground(Color.WHITE);
        WarehousePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        WarehousePanel.setVisible(true);
        // 初始化 RecipeList
        RecipeList = new JList<>();
        RecipeList.setModel(new DefaultListModel<>());
        scrollPane = new JScrollPane(RecipeList);


        // Create a button to go back to the main menu
        back = new JButton("Back");
        WarehousePanel.add(back, BorderLayout.SOUTH);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(back)) {
                    backController.execute()
                    ;
                }
            }
        });
        this.add(WarehousePanel);
    }
    public void display(JPanel WarehousePanel){
        if (recipes != null) {
            // 创建带有滚动条的滚动面板
            scrollPane.setViewportView(RecipeList);
            scrollPane.setPreferredSize(new Dimension(600, 400));
            scrollPane.setBackground(Color.WHITE);
            scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            scrollPane.setVisible(true);
            // 将滚动面板添加到主窗体的中央区域
            WarehousePanel.add(scrollPane);
            RecipeList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) { // 处理单击事件
                        String selectedRecipeTitle = RecipeList.getSelectedValue();
                        if (selectedRecipeTitle != null) {
                            // 在这里处理点击事件，可以获取完整的 Recipe 对象
                            viewRecipeController.execute(selectedRecipeTitle);
                            System.out.println("Clicked on recipe: " + selectedRecipeTitle);
                        }
                    }
                }
            });
            System.out.println("Exit Recipe");
        } else {
            System.out.println("No recipes found.");
        }
    }

    public static String getViewName() {
        return viewName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // 遍历输出调用栈信息
        for (StackTraceElement element : stackTrace) {
            System.out.println(element.toString());
        }
        ViewWarehouseState state = (ViewWarehouseState) evt.getNewValue();
        System.out.println("被触发“propertyChange”事件");
        getDataAndDisplay(state);
    }

    private void getDataAndDisplay(ViewWarehouseState state) {
        recipes = state.getRecipes();
        System.out.println(recipes.size());
        DefaultListModel titleList = new DefaultListModel<>();
        for (Recipe recipe : recipes) {
            titleList.addElement(recipe.getTitle());
        }
        if (recipes != null){
            System.out.println("recipeList: " + titleList);//说明有
        }
        RecipeList.setModel(titleList);
        display(WarehousePanel);
    }

}
// 弹出窗口