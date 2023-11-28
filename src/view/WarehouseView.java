package view;

import entity.Recipe;
import entity.RecipeFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.view_recipe.ViewRecipeController;
import interface_adapter.view_recipe.ViewRecipeViewModel;
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

public class WarehouseView extends JPanel implements ActionListener, PropertyChangeListener {
    public static final String viewName = "Warehouse View";

    private final ViewRecipeController viewRecipeController;
    JList<String> RecipeList; // 创建菜谱列表
    JButton back; // 创建菜谱按钮

    public WarehouseView(ViewRecipeController viewRecipeController, ViewRecipeViewModel viewRecipeViewModel,
                         ViewManagerModel viewManagerModel) {
        JLabel title = new JLabel("Recipe Warehouse");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);



        this.viewRecipeController = viewRecipeController;
        JPanel WarehousePanel = new JPanel();
        WarehousePanel.setLayout(new BorderLayout());
        WarehousePanel.setPreferredSize(new Dimension(600, 400));
        WarehousePanel.setBackground(Color.WHITE);
        WarehousePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        WarehousePanel.setVisible(true);

        // 读取并显示菜谱列表
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
            DefaultListModel<Double> caloriesList = new DefaultListModel<>();
            DefaultListModel<Recipe> recipeList = new DefaultListModel<>();
            for (int i = 0; i < recipesArray.length(); i++) {
                JSONObject recipeObject = recipesArray.getJSONObject(i);
                String recipeTitle = recipeObject.getString("title");
                Integer recipeId = recipeObject.getInt("id");
                String recipeContent = recipeObject.getString("content");
                LocalDateTime recipeDate = LocalDateTime.parse(recipeObject.getString("date"));
                Boolean recipeIsFavorite = recipeObject.getBoolean("isFavorite");
                double recipeCalories = recipeObject.getDouble("calories");
                RecipeFactory recipeFactory = new RecipeFactory();
                Recipe recipe = recipeFactory.create(recipeId, recipeTitle, recipeContent, recipeDate, recipeIsFavorite, recipeCalories);

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
            titleList.addElement("test");
            RecipeList = new JList();
            System.out.println(titleList.size());
            RecipeList.setModel(titleList);

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
                            Recipe selectedRecipe = recipeList.getElementAt(selectedIndex);
                            // 在这里处理点击事件，可以获取完整的 Recipe 对象
                            viewRecipeController.execute(selectedRecipe.getId());
                            System.out.println("Clicked on recipe: " + selectedRecipe.getTitle());
                        }
                    }
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to read recipes.json");
        }
        back = new JButton("Return");
        WarehousePanel.add(back, BorderLayout.SOUTH);
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
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}
// 弹出窗口