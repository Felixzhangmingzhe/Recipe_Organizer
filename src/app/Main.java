package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import data_access.FileRecipeDataAccessObject;
import entity.*;
// 引入各个用例的ViewModel
import interface_adapter.view_warehouse.ViewWarehouseViewModel;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import interface_adapter.view_favorites.ViewFavoritesViewModel;

import view.*;

import interface_adapter.*;

public class Main {
    public static void main(String[] args) {
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
        ViewFavoritesViewModel viewFavoritesViewModel = new ViewFavoritesViewModel();
        ViewRecipeViewModel viewRecipeViewModel = new ViewRecipeViewModel();
        // 为基于文件的用户数据访问初始化 UserDataAccessObject:
        FileRecipeDataAccessObject DAO = new FileRecipeDataAccessObject("recipes.json");
        FileRecipeDataAccessObject viewRecipeDAO = new FileRecipeDataAccessObject("recipes.json");
        // 创建并将视图添加到主面板:
        MainView mainView = MainViewUseCaseFactory.create(viewManagerModel, viewWarehouseViewModel, viewFavoritesViewModel, DAO,viewRecipeViewModel);
        views.add(mainView, mainView.viewName);
        // 设置初始活动视图并使应用程序可见:
        viewManagerModel.setActiveView(mainView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);


        // 在数据库里写入一些菜谱
        RecipePresetter recipePresetter = new RecipePresetter();
        FileRecipeDataAccessObject prDAO = new FileRecipeDataAccessObject("recipes.json");
        recipePresetter.presetData(prDAO);

    }
// 之前写的main被我删了重写了一个
}

