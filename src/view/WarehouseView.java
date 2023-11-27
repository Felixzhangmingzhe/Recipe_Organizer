package view;

import entity.Recipe;
import entity.RecipeFactory;
import interface_adapter.view_recipe.ViewRecipeController;
import org.json.JSONArray;
import org.json.JSONObject;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

public class WarehouseView {
    JPanel WarehousePanel; // 创建总仓库面板，显示所有菜谱
    private final ViewRecipeController viewRecipeController;
    JList<String> RecipeList; // 创建菜谱列表

    public WarehouseView(ViewRecipeController viewRecipeController) {
        this.viewRecipeController = viewRecipeController;
        WarehousePanel = new JPanel();
        WarehousePanel.setLayout(new BorderLayout());
        WarehousePanel.setPreferredSize(new Dimension(600, 400));
        WarehousePanel.setBackground(Color.WHITE);
        WarehousePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        WarehousePanel.setVisible(true);

        // 读取并显示菜谱列表
        readAndDisplayRecipeList();
    }

    private void readAndDisplayRecipeList() {
        try {
            // 从 JSON 文件中读取菜单数据
            String jsonFilePath = "recipes.json"; // 假设文件名为 recipes.json
            JSONArray recipesArray = readJsonFile(jsonFilePath);

            // 将菜单数据添加到 JList
            DefaultListModel<String> titleList = new DefaultListModel<>();
            DefaultListModel<Integer> idList = new DefaultListModel<>();
            DefaultListModel<String> contentList = new DefaultListModel<>();
            DefaultListModel< LocalDateTime > dateList = new DefaultListModel<>();
            DefaultListModel<Boolean> isFavoriteList = new DefaultListModel<>();
            DefaultListModel<Recipe> recipeList = new DefaultListModel<>();
            for (int i = 0; i < recipesArray.length(); i++) {
                JSONObject recipeObject = recipesArray.getJSONObject(i);
                String recipeTitle = recipeObject.getString("title");
                Integer recipeId = recipeObject.getInt("id");
                String recipeContent = recipeObject.getString("content");
                LocalDateTime recipeDate = LocalDateTime.parse(recipeObject.getString("date"));
                Boolean recipeIsFavorite = recipeObject.getBoolean("isFavorite");
                RecipeFactory recipeFactory = new RecipeFactory();
                Recipe recipe = recipeFactory.create(recipeId, recipeTitle, recipeContent, recipeDate, recipeIsFavorite);

                // 将菜谱数据添加到 JList
                titleList.addElement(recipeTitle);
                idList.addElement(recipeId);
                contentList.addElement(recipeContent);
                dateList.addElement(recipeDate);
                isFavoriteList.addElement(recipeIsFavorite);
                recipeList.addElement(recipe);

            }

            RecipeList = new JList<>(titleList);

            // 为 JList 添加鼠标点击事件监听器
            RecipeList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) { // 处理单击事件
                        int selectedIndex = RecipeList.getSelectedIndex();
                        if (selectedIndex != -1) {
                            Recipe selectedRecipe = recipeList.getElementAt(selectedIndex);
                            // 在这里处理点击事件，可以获取完整的 Recipe 对象
                            viewRecipeController.execute(selectedRecipe.getId());
                            System.out.println("Clicked on recipe: " + selectedRecipe.getTitle());
                        }
                    }
                }
            });

            // 创建带有滚动条的滚动面板
            JScrollPane scrollPane = new JScrollPane(RecipeList);

            // 将滚动面板添加到主窗体的中央区域
            WarehousePanel.add(scrollPane, BorderLayout.CENTER);

        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public JPanel getWarehousePanel() {
        return WarehousePanel;
    }

}
