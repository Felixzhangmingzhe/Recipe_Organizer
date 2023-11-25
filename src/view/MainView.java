package view;

import interface_adapter.view_warehouse.ViewWarehouseState;
import interface_adapter.view_warehouse.ViewWarehouseViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
// Use Case:View Warehouse
import interface_adapter.view_warehouse.*;
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
    private final ViewWarehouseState viewWarehouseState;






    public MainView(JButton cancel) {
        JLabel title = new JLabel("Main Menu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

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
                        ViewWarehouseState state = ViewWarehouseViewModel.getState();
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
