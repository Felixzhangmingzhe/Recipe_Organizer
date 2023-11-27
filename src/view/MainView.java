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
// Use Case:View Warehouse
import interface_adapter.ViewManagerModel;
import interface_adapter.view_warehouse.*;
// Use Case:View Favorites
import interface_adapter.view_favorites.*;
public class MainView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "main view";

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






    public MainView(ViewWarehouseController viewWarehouseController, ViewWarehouseViewModel viewWarehouseViewModel,
                    ViewFavoritesController viewFavoritesController, ViewFavoritesViewModel viewFavoritesViewModel,
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
                        List< Recipe > recipes = currentState.getRecipes();
                        // 接下来，把recipes展示出来
                    }
                }
            }
        );

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
                        List< Recipe > recipes = viewFavoritesViewModel.getRecipes();
                        // 接下来，把recipes展示出来
                        // 目前
                    }
                }
            }
        );

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
