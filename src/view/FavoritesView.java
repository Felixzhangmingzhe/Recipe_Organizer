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
    JScrollPane scrollPane;
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
        scrollPane = new JScrollPane(RecipeList);


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
        System.out.println("FavoritesView instantiated run");
    }
    public void display(JPanel panel) {
        if (favoriteRecipes != null) {
            scrollPane.setViewportView(RecipeList);
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
                        String selectedRecipeTitle = RecipeList.getSelectedValue();
                        System.out.println("The program arriving at mouseclicked");
                        if (selectedRecipeTitle != null) {
                            // 在这里处理点击事件，可以获取完整的 Recipe 对象
                            viewRecipeController.execute(selectedRecipeTitle);
                            System.out.println("Clicked on recipe: " + selectedRecipeTitle);
                        }
                    }
                }
            });
            System.out.println("Recipe exit report in display");
        } else {
            System.out.println("No recipes found.");
        }

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
        if (evt.getPropertyName().equals("recipes")) {// since viewRecipeViewModel and viewFavoritesViewModel are both propertyChangeListeners, we need to distinguish them
            ViewFavoritesViewModel currentState = viewFavoritesViewModel;
            getAndDisplay(currentState);
        }
    }
    public void getAndDisplay(ViewFavoritesViewModel currentState){
            favoriteRecipes = currentState.getRecipes();
            System.out.println(favoriteRecipes.size());
            DefaultListModel titleList = new DefaultListModel<>();
            for (Recipe recipe : favoriteRecipes) {
                titleList.addElement(recipe.getTitle());
            }
            System.out.println("getAndDisplay run");
            System.out.println("recipeList: " + titleList);//说明有
            RecipeList.setModel(titleList);
            display(FavoritesPanel);
    }
}
