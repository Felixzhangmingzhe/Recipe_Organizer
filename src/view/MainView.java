package view;

import entity.Recipe;
import interface_adapter.view_warehouse.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
// Use Case:View Warehouse
import interface_adapter.view_warehouse.*;
public class MainView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "main";

    private final JButton createRecipe;
    private final JButton dailySpecial;
    private final JButton favorites;
    private final JButton exit;
    private final JButton allRecipes;
    // Use Case:View Warehouse
    private final ViewWarehouseController viewWarehouseController;
    private final ViewWarehouseViewModel viewWarehouseViewModel;






    public MainView(ViewWarehouseController viewWarehouseController, ViewWarehouseViewModel viewWarehouseViewModel) {
        JLabel title = new JLabel("Main Menu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        // 初始化, 只需要controller和viewmodel
        // // 初始化ViewWarehouse有关
        this.viewWarehouseController = viewWarehouseController;
        this.viewWarehouseViewModel = viewWarehouseViewModel;







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
