package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import data_access.FileRecipeDataAccessObject;
import entity.*;
import interface_adapter.view_warehouse.ViewWarehouseViewModel;
import view.*;
import use_case.*;
import interface_adapter.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Main {

    private static void createAndShowGUI() {
        // 模拟一些菜谱数据
        List<Recipe> recipes = createDummyRecipes();

        // 创建 FavoritesView 实例，并传递菜谱数据
        FavoritesView favoritesView = new FavoritesView();

        // 创建一个 JFrame 并将 TotalFavoritesPanel 添加到其中
        JFrame frame = new JFrame("Recipe Organizer");
        frame.getContentPane().add(favoritesView.getTotalfavoritesPanel());

        // 设置关闭操作和显示窗口
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // 模拟创建一些菜谱数据的方法
    private static List<Recipe> createDummyRecipes() {
        List<Recipe> recipes = new ArrayList<>();

        // 添加一些模拟的菜谱数据
        recipes.add(new Recipe(1, "Chicken Parmesan", "Classic chicken parmesan with marinara sauce and melted cheese.",LocalDateTime.now()));
        return recipes;
    }
    public static <ViewRecipeViewModel> void main(String[] args) {
        // 这里创建了一个主应用窗口，然后设置了关闭操作
        JFrame application = new JFrame("Recipe Organizer");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 创建一个 CardLayout，用于管理各个卡片
        CardLayout cardLayout = new CardLayout();
        // 创建一个 JPanel，用于存放各个卡片
        JPanel views = new JPanel(new CardLayout());
        application.add(views);
        // 创建用于管理视图的 ViewManager:
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);
        // 为每个ViewModel创建一个实例，大家记得要传入自己对应的ViewModel
        ViewWarehouseViewModel viewWarehouseViewModel = new ViewWarehouseViewModel();
        ViewRecipeViewModel viewRecipeViewModel = new ViewRecipeViewModel();
        // 为基于文件的用户数据访问初始化 UserDataAccessObject:
        FileRecipeDataAccessObject DAO = new FileRecipeDataAccessObject("recipes.json");
        FileRecipeDataAccessObject viewRecipeDAO = new FileRecipeDataAccessObject("recipes.json");
        // 创建并将视图添加到主面板:
        MainView mainView = MainViewUseCaseFactory.create(viewManagerModel, viewWarehouseViewModel, viewRecipeViewModel, DAO, viewRecipeDAO);
        views.add(mainView, mainView.viewName);
        // 设置初始活动视图并使应用程序可见:
        viewManagerModel.setActiveView(mainView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);


    }
    public static void mainoutdate(String[] args) {
        // Set the file path for the FavoritesView
        FavoritesView favoritesView = new FavoritesView();

        // Create a FileRecipeDataAccessObject with the appropriate file path
        FileRecipeDataAccessObject dao = new FileRecipeDataAccessObject("recipes.json");

        // Adding a recipe for testing
        LocalDateTime date = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
        Recipe newRecipe = new Recipe(1, "Spaghetti Bolognese", "Cook the spaghetti. Cook the ground beef. Mix them together.", date);
        dao.addRecipe(newRecipe);

        // Reading all recipes
        List<Recipe> allRecipes = dao.readRecipes();

        // Display recipes in the console
        System.out.println("All Recipes:");
        for (Recipe recipe : allRecipes) {
            System.out.println(recipe);
        }

        // Show the total favorites view
        favoritesView.showTotalFavorites();


        // Create a cancel button (you can replace it with your actual cancel button)
        JButton cancelButton = new JButton("Cancel");

        // Create an instance of MainView
        MainView mainView = new MainView(cancelButton);

        // Create a JFrame to hold the MainView
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainView);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);

        // Add an ActionListener to the cancel button to close the frame
        cancelButton.addActionListener(e -> frame.dispose());
    }
}

