package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

// Use Case:View Warehouse
import interface_adapter.ViewManagerModel;
import interface_adapter.open_create_recipe.OpenCreateRecipeController;
import interface_adapter.open_create_recipe.OpenCreateRecipeViewModel;
import interface_adapter.show_daily_special.ShowDailySpecialController;
import interface_adapter.show_daily_special.ShowDailySpecialState;
import interface_adapter.show_daily_special.ShowDailySpecialViewModel;
import interface_adapter.view_search.ViewSearchController;
import interface_adapter.view_search.ViewSearchState;
import interface_adapter.view_search.ViewSearchViewModel;
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
    private final JButton search;
    // Use Case:View Warehouse
    private final ViewWarehouseController viewWarehouseController;
    private final ViewWarehouseViewModel viewWarehouseViewModel;

    // Use Case:View Favorites
    private final ViewFavoritesController viewFavoritesController;
    private final ViewFavoritesViewModel viewFavoritesViewModel;

    // Use Case:Open Create Recipe
    private final OpenCreateRecipeViewModel openCreateRecipeViewModel;
    private final OpenCreateRecipeController openCreateRecipeController;

    // Use Case:View Search
    private final ViewSearchController viewSearchController;
    private final ViewSearchViewModel viewSearchViewModel;

    // Use Case:Show Daily Special
    private final ShowDailySpecialViewModel showDailySpecialViewModel;
    private final ShowDailySpecialController showDailySpecialController;







    public MainView(ViewWarehouseController viewWarehouseController, ViewWarehouseViewModel viewWarehouseViewModel,
                    ViewFavoritesController viewFavoritesController, ViewFavoritesViewModel viewFavoritesViewModel,
                    OpenCreateRecipeViewModel openCreateRecipeViewModel, OpenCreateRecipeController openCreateRecipeController,
                    ViewManagerModel viewManagerModel, ViewSearchController viewSearchController, ViewSearchViewModel viewSearchViewModel, ShowDailySpecialViewModel showDailySpecialViewModel, ShowDailySpecialController showDailySpecialController) {
        //初始化Daily Special有关
        this.showDailySpecialViewModel = showDailySpecialViewModel;
        this.showDailySpecialController = showDailySpecialController;
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
        // // 初始化ViewSearch有关
        this.viewSearchViewModel = viewSearchViewModel;
        this.viewSearchController = viewSearchController;





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
        search = new JButton("Search");
        buttons.add(search);



        createRecipe.addActionListener(//打开菜谱界面（创建菜谱模式）
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == createRecipe) {//if (e.getSource() == createRecipe)
                        openCreateRecipeController.execute();
                    }
                }
            }
        );
        search.addActionListener(//搜索菜谱界面
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == search) {//if (e.getSource() == createRecipe)
                            ViewSearchState currentState = viewSearchViewModel.getState();
                            viewSearchController.execute();
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
                    }
                }
            }
        );
        dailySpecial.addActionListener(//打开菜谱界面（浏览菜谱模式）
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == dailySpecial) {//if (e.getSource() == createRecipe)
                            ShowDailySpecialState currentState = showDailySpecialViewModel.getState();
                            showDailySpecialController.execute();
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
        System.out.println("MainView is running");
        JOptionPane.showMessageDialog(this, "MainView: " + evt.getPropertyName() + " " + evt.getNewValue());
    }
}
