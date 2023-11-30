package view;

import data_access.FileRecipeDataAccessObject;
import entity.Recipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.concurrent.Executor;
// Use Case:View Warehouse
import interface_adapter.ViewManagerModel;
import interface_adapter.create_recipe.CreateRecipeController;
import interface_adapter.create_recipe.CreateRecipeViewModel;
import interface_adapter.open_create_recipe.OpenCreateRecipeController;
import interface_adapter.open_create_recipe.OpenCreateRecipeViewModel;
import interface_adapter.view_warehouse.*;
// Use Case:View Favorites
import interface_adapter.view_favorites.*;
public class MainView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "Initial Interface";
    private final JButton createRecipe;
    private final JButton dailySpecial;
    private final JButton favorites;
    private final JButton exit;
    private final JButton allRecipes;
    // Use Case:View Warehouse
    private final ViewWarehouseController viewWarehouseController;
    private final ViewWarehouseViewModel viewWarehouseViewModel;

    // Use Case:View Favorites
    private final ViewFavoritesController viewFavoritesController;
    private final ViewFavoritesViewModel viewFavoritesViewModel;

    // Use Case:Open Create Recipe
    private final OpenCreateRecipeViewModel openCreateRecipeViewModel;
    private final OpenCreateRecipeController openCreateRecipeController;






    public MainView(ViewWarehouseController viewWarehouseController, ViewWarehouseViewModel viewWarehouseViewModel,
                    ViewFavoritesController viewFavoritesController, ViewFavoritesViewModel viewFavoritesViewModel,
                    OpenCreateRecipeViewModel openCreateRecipeViewModel, OpenCreateRecipeController openCreateRecipeController,
                    ViewManagerModel viewManagerModel) {
        JLabel title = new JLabel("Main Menu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 初始化, 只需要controller和viewmodel
        // // 初始化ViewWarehouse有关
        this.viewWarehouseController = viewWarehouseController;
        this.viewWarehouseViewModel = viewWarehouseViewModel;
        // // 初始化ViewFavorites有关
        this.viewFavoritesController = viewFavoritesController;
        this.viewFavoritesViewModel = viewFavoritesViewModel;
        // // 初始化OpenCreateRecipe有关
        this.openCreateRecipeViewModel = openCreateRecipeViewModel;
        this.openCreateRecipeController = openCreateRecipeController;





        // 添加菜单按钮
        JPanel buttons = new JPanel();
        createRecipe = new JButton("Create Recipe");
        buttons.add(createRecipe);
        favorites = new JButton("Favorites");
        buttons.add(favorites);
        exit = new JButton("Exit");
        buttons.add(exit);
        allRecipes = new JButton("All Recipes");
        buttons.add(allRecipes);
        dailySpecial = new JButton("Daily Recipe");
        buttons.add(dailySpecial);



        createRecipe.addActionListener(//打开菜谱界面（创建菜谱模式）
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == createRecipe) {//if (e.getSource() == createRecipe)
                        openCreateRecipeController.execute();
                    }
                }
            }
        );
        allRecipes.addActionListener(//打开菜谱界面（浏览菜谱模式）
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == allRecipes) {//if (e.getSource() == createRecipe)
                        ViewWarehouseState currentState = viewWarehouseViewModel.getState();
                        viewWarehouseController.execute();
                        List<Recipe> recipes = currentState.getRecipes();
                    }
                }
            }
        );
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在这里添加退出应用程序的逻辑
                System.exit(0); // 或者其他你认为合适的退出逻辑
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
        //

        favorites.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(favorites)) {
                        viewFavoritesController.execute();
                        // 接下来，把recipes展示出来
                        // 目前
                    }
                }
            }
        );
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在这里添加退出应用程序的逻辑
                System.exit(0); // 或者其他你认为合适的退出逻辑
            }
        });
    }



    public void addRecipeButtonListener(ActionListener listener) {
        createRecipe.addActionListener(listener);
    }

    public void addFavoritesButtonListener(ActionListener listener) {
        favorites.addActionListener(listener);
    }
    /**
     * React to a button click that results in evt.
     */
    @Override
    public void actionPerformed(ActionEvent e) {JOptionPane.showMessageDialog(this, "MainView: " + e.getActionCommand());

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
