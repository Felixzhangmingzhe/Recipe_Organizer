package view;

import entity.Recipe;
import entity.RecipeFactory;
import interface_adapter.Back.BackController;
import interface_adapter.ViewManagerModel;
import interface_adapter.view_recipe.ViewRecipeController;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import interface_adapter.view_warehouse.ViewWarehouseState;
import org.json.JSONArray;
import org.json.JSONObject;


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
    private List<Recipe> recipes;
    JButton back; // 创建菜谱按钮
    private final ViewRecipeViewModel viewRecipeViewModel;

    private final BackController backController;
    private final ViewManagerModel viewManagerModel;

    private JPanel WarehousePanel = new JPanel();

    public WarehouseView(ViewRecipeController viewRecipeController, ViewRecipeViewModel viewRecipeViewModel,
                         BackController backController,
                         ViewManagerModel viewManagerModel) {
        JLabel title = new JLabel("Recipe Warehouse");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.viewRecipeViewModel = viewRecipeViewModel;
        this.viewRecipeController = viewRecipeController;
        this.backController = backController;
        this.viewManagerModel = viewManagerModel;

        // 初始化界面元素
        WarehousePanel.setLayout(new BorderLayout());
        WarehousePanel.setPreferredSize(new Dimension(600, 400));
        WarehousePanel.setBackground(Color.WHITE);
        WarehousePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        WarehousePanel.setVisible(true);

        // Display the recipe list

        if (recipes != null) {
            DefaultListModel titleList = new DefaultListModel<>();
            DefaultListModel<Integer> idList = new DefaultListModel<>();
            DefaultListModel<String> contentList = new DefaultListModel<>();
            DefaultListModel<LocalDateTime> dateList = new DefaultListModel<>();
            DefaultListModel<Boolean> isFavoriteList = new DefaultListModel<>();
            DefaultListModel<Double> caloriesList = new DefaultListModel<>();
            DefaultListModel<Recipe> recipeList = new DefaultListModel<>();
            for (int i = 0; i < recipes.size(); i++) {
                Recipe recipe = recipes.get(i);
                String recipeTitle = recipe.getTitle();
                Integer recipeId = recipe.getId();
                String recipeContent = recipe.getContent();
                LocalDateTime recipeDate = recipe.getDate();
                Boolean recipeIsFavorite = recipe.getIsFavorite();
                double recipeCalories = recipe.getCalories();

                // 将菜谱数据添加到 JList
                titleList.addElement(recipeTitle);
                idList.addElement(recipeId);
                contentList.addElement(recipeContent);
                dateList.addElement(recipeDate);
                isFavoriteList.addElement(recipeIsFavorite);
                caloriesList.addElement(recipeCalories);
                recipeList.addElement(recipe);
            }
            System.out.println("recipeList: " + titleList);//说明有
            RecipeList = new JList<>(titleList);
            // 为 JList 添加鼠标点击事件监听器


            // 创建带有滚动条的滚动面板
            JScrollPane scrollPane = new JScrollPane(RecipeList);
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
                        int selectedIndex = RecipeList.getSelectedIndex();
                        if (selectedIndex != -1) {
                            Recipe selectedRecipe = recipes.get(selectedIndex);
                            // 在这里处理点击事件，可以获取完整的 Recipe 对象
                            viewRecipeController.execute(selectedRecipe.getId());
                            System.out.println("Clicked on recipe: " + selectedRecipe.getTitle());
                        }
                    }
                }
            });
            System.out.println("Exit Recipe");
        } else {
            System.out.println("No recipes found.");
        }



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


    private JSONArray readJsonFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileReader reader = new FileReader(file);

        StringBuilder content = new StringBuilder();
        int character;
        while ((character = reader.read()) != -1) {
            content.append((char) character);
        }

        reader.close();

        return new JSONArray(content.toString());
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
    }

}
// 弹出窗口