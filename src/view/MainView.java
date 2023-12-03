package view;

import entity.Recipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.List;

import java.util.concurrent.Executor;
import data_access.FileRecipeDataAccessObject;

import interface_adapter.create_recipe.CreateRecipeController;
import interface_adapter.create_recipe.CreateRecipeViewModel;

// Use Case:View Warehouse
import interface_adapter.ViewManagerModel;
import interface_adapter.open_create_recipe.OpenCreateRecipeController;
import interface_adapter.open_create_recipe.OpenCreateRecipeViewModel;
import interface_adapter.show_daily_special.ShowDailySpecialController;
import interface_adapter.show_daily_special.ShowDailySpecialState;
import interface_adapter.show_daily_special.ShowDailySpecialViewModel;
import interface_adapter.view_search.ViewSearchController;
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
                    ViewManagerModel viewManagerModel, ViewSearchController viewSearchController, ViewSearchViewModel viewSearchViewModel,
                    ShowDailySpecialViewModel showDailySpecialViewModel, ShowDailySpecialController showDailySpecialController) {
        JLabel title = new JLabel("Main Menu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

//        //logo
//        // 创建 ImageIcon
//        ImageIcon originalIcon = new ImageIcon("src/view/platePal-logo.png"); // 将 "path/to/your/image.png" 替换为您的图片文件路径
//        // 获取原始图片并调整大小
//        Image image = originalIcon.getImage();
//        int newWidth = 200;
//        int newHeight = 200;
//        Image newimg = image.getScaledInstance(newWidth, newHeight,  java.awt.Image.SCALE_SMOOTH); // newWidth 和 newHeight 是新的宽度和高度
//        ImageIcon imageIcon = new ImageIcon(newimg);
//
//        // 创建 JLabel 并设置新的 ImageIcon
//        JLabel imageLabel = new JLabel(imageIcon);
//        // 将 JLabel 添加到 JPanel
//        this.add(imageLabel);

        // 假设您已经有了一个名为 imageLabel 的 JLabel 对象

// 调整 ImageIcon 大小
        ImageIcon originalIcon = new ImageIcon("src/view/platePal-logo.png"); // 替换为您的图片路径
        Image image = originalIcon.getImage();
// 增加尺寸至原来的1.5倍
        // 指定新的宽度和高度，根据需要调整这些值
        int newWidth = 250; // 或者根据视图大小更小的值
        int newHeight = 250; // 或者根据视图大小更小的值
        Image newimg = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newimg);

// 为 JLabel 设置新的 ImageIcon
        JLabel imageLabel = new JLabel(imageIcon);

// 将 JLabel 设置为居中对齐
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

// 添加到面板
// 创建一个新的 JPanel 来放置 JLabel，确保它可以居中
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.LINE_AXIS));
        imagePanel.add(Box.createHorizontalGlue()); // 添加弹性空白区域
        imagePanel.add(imageLabel);
        imagePanel.add(Box.createHorizontalGlue()); // 添加弹性空白区域

// 现在将这个新的 imagePanel 添加到主视图中
// 例如，如果您的主视图使用 BoxLayout，则可以这样添加：
        this.add(imagePanel);





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
        // // 初始化ShowDailySpecial有关
        this.showDailySpecialViewModel = showDailySpecialViewModel;
        this.showDailySpecialController = showDailySpecialController;





//        // 添加菜单按钮
//        JPanel buttons = new JPanel();
//        createRecipe = new JButton("Create Recipe");
//        buttons.add(createRecipe);
//        favorites = new JButton("Favorites");
//        buttons.add(favorites);
//        exit = new JButton("Exit");
//        buttons.add(exit);
//        allRecipes = new JButton("All Recipes");
//        buttons.add(allRecipes);
//        dailySpecial = new JButton("Daily Recipe");
//        buttons.add(dailySpecial);
//        search = new JButton("Search");
//        buttons.add(search);


// 在构造函数中，添加按钮到两个不同的面板
        JPanel topRowButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JPanel bottomRowButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

// 创建并添加按钮到第一排
        createRecipe = new JButton("Create Recipe");
        topRowButtons.add(createRecipe);

        allRecipes = new JButton("All Recipes");
        topRowButtons.add(allRecipes);

        dailySpecial = new JButton("Daily Recipe");
        topRowButtons.add(dailySpecial);

// 创建并添加按钮到第二排
        favorites = new JButton("Favorites");
        bottomRowButtons.add(favorites);

        search = new JButton("Search");
        bottomRowButtons.add(search);

        exit = new JButton("Exit");
        bottomRowButtons.add(exit);

// 设置主面板的布局为 BoxLayout，以便垂直排列组件
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

// 添加标题、两排按钮面板和 logo 到主面板
        this.add(title);
        this.add(imageLabel);
        this.add(topRowButtons);
        this.add(bottomRowButtons);





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
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在这里添加退出应用程序的逻辑
                System.exit(0); // 或者其他你认为合适的退出逻辑
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

//        this.add(title);
//        this.add(buttons);
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
        dailySpecial.addActionListener(//打开菜谱界面（浏览菜谱模式）
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == dailySpecial) {//if (e.getSource() == createRecipe)
                            ShowDailySpecialState currentState = showDailySpecialViewModel.getState();
                            try {
                                showDailySpecialController.execute();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
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
