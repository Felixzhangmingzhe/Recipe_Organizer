package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import data_access.FileRecipeDataAccessObject;
import entity.*;
import view.*;
import use_case.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
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
    public static void main(String[] args) {
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

