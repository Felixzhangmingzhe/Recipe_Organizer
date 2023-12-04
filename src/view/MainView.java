package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import interface_adapter.Back.BackState;
import interface_adapter.Back.BackViewModel;

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
    private JButton activityLevelButton;
    private final JLabel title;
    private int numOfCooked = 0;
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
    // Use Case:Back
    private final BackViewModel backViewModel;





    public MainView(ViewWarehouseController viewWarehouseController, ViewWarehouseViewModel viewWarehouseViewModel,
                    ViewFavoritesController viewFavoritesController, ViewFavoritesViewModel viewFavoritesViewModel,
                    OpenCreateRecipeViewModel openCreateRecipeViewModel, OpenCreateRecipeController openCreateRecipeController,
                    ViewManagerModel viewManagerModel, ViewSearchController viewSearchController, ViewSearchViewModel viewSearchViewModel,
                    BackViewModel backViewModel,
                    ShowDailySpecialViewModel showDailySpecialViewModel, ShowDailySpecialController showDailySpecialController) {
//// 调整 ImageIcon 大小
//        ImageIcon originalIcon = new ImageIcon("src/view/platePal-logo.png"); // 替换为您的图片路径
//        Image image = originalIcon.getImage();
//// 增加尺寸至原来的1.5倍
//        // 指定新的宽度和高度，根据需要调整这些值
//        int newWidth = 250; // 或者根据视图大小更小的值
//        int newHeight = 250; // 或者根据视图大小更小的值
//        Image newimg = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
//        ImageIcon imageIcon = new ImageIcon(newimg);
//
//// 为 JLabel 设置新的 ImageIcon
//        JLabel imageLabel = new JLabel(imageIcon);
//
//// 将 JLabel 设置为居中对齐
//        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//// 添加到面板
//// 创建一个新的 JPanel 来放置 JLabel，确保它可以居中
//        JPanel imagePanel = new JPanel();
//        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.LINE_AXIS));
//        imagePanel.add(Box.createHorizontalGlue()); // 添加弹性空白区域
//        imagePanel.add(imageLabel);
//        imagePanel.add(Box.createHorizontalGlue()); // 添加弹性空白区域
//
//// 现在将这个新的 imagePanel 添加到主视图中
//// 例如，如果您的主视图使用 BoxLayout，则可以这样添加：
//        this.add(imagePanel);





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
        // // 初始化Back有关
        this.backViewModel = backViewModel;
        this.backViewModel.addPropertyChangeListener(this);

        activityLevelButton = new JButton("Activity Level: " + numOfCooked);
        JPanel activityLevelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        activityLevelPanel.add(activityLevelButton);

        // 创建标题和设置对齐
        title = new JLabel("Are you hungry?");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 创建并调整图像标签的大小
        ImageIcon originalIcon = new ImageIcon("src/view/platePal-logo.png"); // 请替换为您的图片路径
        Image image = originalIcon.getImage();
        Image newimg = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH); // 根据需要调整这些值
        ImageIcon imageIcon = new ImageIcon(newimg);
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 将活动等级面板、标题和图像标签添加到一个箱式布局的面板中
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(activityLevelPanel);
        topPanel.add(title);
        topPanel.add(imageLabel);

        // 创建第一行按钮的面板
        JPanel firstRowButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        createRecipe = new JButton("Create Recipe");
        allRecipes = new JButton("All Recipes");
        dailySpecial = new JButton("Daily Recipe");
        firstRowButtons.add(createRecipe);
        firstRowButtons.add(allRecipes);
        firstRowButtons.add(dailySpecial);

        // 创建第二行按钮的面板
        JPanel secondRowButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        favorites = new JButton("Favorites");
        search = new JButton("Search");
        exit = new JButton("Exit");
        secondRowButtons.add(favorites);
        secondRowButtons.add(search);
        secondRowButtons.add(exit);

        // 创建一个中心面板来垂直排列两行按钮面板
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(firstRowButtons);
        centerPanel.add(secondRowButtons);

        // 设置主面板的布局并添加组件
        this.setLayout(new BorderLayout());
        this.add(topPanel, BorderLayout.NORTH); // 将顶部面板添加到北区
        this.add(centerPanel, BorderLayout.CENTER); // 将包含两行按钮的中心面板添加到中央





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
        activityLevelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == activityLevelButton) {
                    // 加载原始图标
                    ImageIcon originalIcon = new ImageIcon("src/view/tree.png"); // 替换为你的图标文件路径

                    // 获取原始图像，并进行缩放
                    Image originalImage = originalIcon.getImage();
                    Image scaledImage = originalImage.getScaledInstance(80, 80, Image.SCALE_SMOOTH); // 将图标的宽度和高度设置为30像素

                    // 将缩放后的图像转换回 ImageIcon
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);

                    // 显示一个带有自定义图标的消息对话框
                    JOptionPane.showMessageDialog(null, "这里是你的消息", "标题", JOptionPane.INFORMATION_MESSAGE, scaledIcon);
                }
            }
        });

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
    public void setNumOfCooked(int numOfCooked) {
        numOfCooked = numOfCooked;
        activityLevelButton.setText("Activity Level: " + numOfCooked);
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
        System.out.println("MainView.propertyChange");
        if (evt.getPropertyName().equals("back")) {
            BackState state = (BackState) evt.getNewValue();
            refreshActivityLevelLabel(state);
        }
    }
    public void refreshActivityLevelLabel(BackState state) {

        numOfCooked = state.getNumOfCooked();
        activityLevelButton.setText("Activity Level: " + numOfCooked);
        System.out.println("MainView.refreshActivityLevelLabel");
        title.setText("Have you cooked today?");
    }
}