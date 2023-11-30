package view;

import entity.Recipe;
import interface_adapter.Back.BackController;
import interface_adapter.ViewManagerModel;
import interface_adapter.view_favorites.ViewFavoritesViewModel;
import interface_adapter.view_recipe.ViewRecipeController;
import interface_adapter.view_recipe.ViewRecipeViewModel;
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

public class FavoritesView extends JPanel implements ActionListener, PropertyChangeListener {
    public static final String viewName = "Favorites";

    private final ViewRecipeController viewRecipeController;
    JList<String> RecipeList; // 创建菜谱列表
    private List<Recipe> favoriteRecipes;
    JPanel FavoritesPanel = new JPanel();
    JButton back; // 创建菜谱按钮
    private final ViewRecipeViewModel viewRecipeViewModel;

    private final BackController backController;
    private final ViewManagerModel viewManagerModel;
    private final ViewFavoritesViewModel viewFavoritesViewModel;

    public FavoritesView(ViewRecipeController viewRecipeController,
                         ViewRecipeViewModel viewRecipeViewModel,
                         BackController backController,
                         ViewFavoritesViewModel viewFavoritesViewModel,
                         ViewManagerModel viewManagerModel) {
        JLabel title = new JLabel("Favorite Recipes");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.viewRecipeViewModel = viewRecipeViewModel;
        this.viewRecipeController = viewRecipeController;
        this.backController = backController;
        this.viewManagerModel = viewManagerModel;
        this.viewRecipeViewModel.addPropertyChangeListener(this);
        this.viewFavoritesViewModel = viewFavoritesViewModel;
        this.viewFavoritesViewModel.addPropertyChangeListener(this);



        // 初始化界面元素
        FavoritesPanel.setLayout(new BorderLayout());
        FavoritesPanel.setPreferredSize(new Dimension(600, 400));
        FavoritesPanel.setBackground(Color.WHITE);
        FavoritesPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        FavoritesPanel.setVisible(true);

        // 初始化 RecipeList
        RecipeList = new JList<>();
        RecipeList.setModel(new DefaultListModel<>());

        // Display the recipe list

        if (favoriteRecipes != null) {
            DefaultListModel titleList = new DefaultListModel<>();
            DefaultListModel<Integer> idList = new DefaultListModel<>();
            DefaultListModel<String> contentList = new DefaultListModel<>();
            DefaultListModel<LocalDateTime> dateList = new DefaultListModel<>();
            DefaultListModel<Boolean> isFavoriteList = new DefaultListModel<>();
            DefaultListModel<Double> caloriesList = new DefaultListModel<>();
            DefaultListModel<Recipe> recipeList = new DefaultListModel<>();
            for (Recipe recipe: favoriteRecipes) {
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
            FavoritesPanel.add(scrollPane);
            RecipeList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) { // 处理单击事件
                        int selectedIndex = RecipeList.getSelectedIndex();
                        if (selectedIndex != -1) {
                            Recipe selectedRecipe = favoriteRecipes.get(selectedIndex);
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
        back = new JButton("Back");
        FavoritesPanel.add(back, BorderLayout.SOUTH);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(back)) {
                    backController.execute()
                    ;
                }
            }
        });
        this.add(FavoritesPanel);
    }
    public void display(JPanel panel) {
        if (favoriteRecipes != null) {
            DefaultListModel titleList = new DefaultListModel<>();
            DefaultListModel<Integer> idList = new DefaultListModel<>();
            DefaultListModel<String> contentList = new DefaultListModel<>();
            DefaultListModel<LocalDateTime> dateList = new DefaultListModel<>();
            DefaultListModel<Boolean> isFavoriteList = new DefaultListModel<>();
            DefaultListModel<Double> caloriesList = new DefaultListModel<>();
            DefaultListModel<Recipe> recipeList = new DefaultListModel<>();
            for (Recipe recipe: favoriteRecipes) {
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
            FavoritesPanel.add(scrollPane);
            RecipeList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) { // 处理单击事件
                        int selectedIndex = RecipeList.getSelectedIndex();
                        if (selectedIndex != -1) {
                            Recipe selectedRecipe = favoriteRecipes.get(selectedIndex);
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
        ViewFavoritesViewModel currentState = viewFavoritesViewModel;
        getAndDisplay(currentState);
    }
    public void getAndDisplay(ViewFavoritesViewModel currentState){
            favoriteRecipes = currentState.getRecipes();
            System.out.println(favoriteRecipes.size());
            DefaultListModel titleList = new DefaultListModel<>();
            for (Recipe recipe : favoriteRecipes) {
                titleList.addElement(recipe.getTitle());
            }
            if (favoriteRecipes != null){
                System.out.println("recipeList: " + titleList);//说明有
            }
            RecipeList.setModel(titleList);
            display(FavoritesPanel);

    }
}
