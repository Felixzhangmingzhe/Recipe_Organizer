package app;

import javax.swing.*;
import java.awt.*;

import data_access.FileRecipeDataAccessObject;
import interface_adapter.Back.BackViewModel;
import interface_adapter.add_to_favorites.AddToFavoritesViewModel;
import interface_adapter.click_search.ClickSearchViewModel;
import interface_adapter.cooked.CookedViewModel;
import interface_adapter.create_recipe.CreateRecipeViewModel;
import interface_adapter.jump_to_edit.JumpToEditViewModel;
import interface_adapter.open_create_recipe.OpenCreateRecipeViewModel;
import interface_adapter.show_daily_special.ShowDailySpecialViewModel;
import interface_adapter.view_search.ViewSearchViewModel;
import interface_adapter.view_warehouse.ViewWarehouseViewModel;
import interface_adapter.view_recipe.ViewRecipeViewModel;
import interface_adapter.view_favorites.ViewFavoritesViewModel;

import view.*;

import interface_adapter.*;

public class Main {
    public static void main(String[] args) {
        // 这里创建了一个主应用窗口，然后设置了关闭操作
        JFrame application = new JFrame("PlatePal");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 创建一个 CardLayout，用于管理各个卡片
        CardLayout cardLayout = new CardLayout();
        // 创建一个 JPanel，用于存放各个卡片
        JPanel views = new JPanel(cardLayout);
        application.add(views);
        // 创建用于管理视图的 ViewManager:
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);



        // 为每个ViewModel创建一个实例，大家记得要传入自己对应的ViewModel######################################################IMPORTANT
        ViewWarehouseViewModel viewWarehouseViewModel = new ViewWarehouseViewModel();
        ViewFavoritesViewModel viewFavoritesViewModel = new ViewFavoritesViewModel();
        ViewRecipeViewModel viewRecipeViewModel = new ViewRecipeViewModel();
        OpenCreateRecipeViewModel openCreateRecipeViewModel = new OpenCreateRecipeViewModel();
        BackViewModel backViewModel = new BackViewModel();
        CreateRecipeViewModel createRecipeViewModel = new CreateRecipeViewModel();
        ViewSearchViewModel viewSearchViewModel = new ViewSearchViewModel();
        AddToFavoritesViewModel addToFavoritesViewModel = new AddToFavoritesViewModel();
        CookedViewModel cookedViewModel = new CookedViewModel();
        ShowDailySpecialViewModel showDailySpecialViewModel = new ShowDailySpecialViewModel();
        ClickSearchViewModel clickSearchViewModel = new ClickSearchViewModel();
        JumpToEditViewModel jumpToEditViewModel = new JumpToEditViewModel();





        // 为基于文件的用户数据访问初始化 UserDataAccessObject:
        FileRecipeDataAccessObject DAO = new FileRecipeDataAccessObject("recipes.json");
        FileRecipeDataAccessObject viewRecipeDAO = new FileRecipeDataAccessObject("recipes.json");
        FileRecipeDataAccessObject warehouseDAO = new FileRecipeDataAccessObject("recipes.json");

        // 创建并将视图添加到主面板:主视图
        MainView mainView = MainViewUseCaseFactory.create(viewManagerModel, viewWarehouseViewModel, viewFavoritesViewModel, openCreateRecipeViewModel, backViewModel,DAO, viewRecipeViewModel, viewSearchViewModel, showDailySpecialViewModel);
        mainView.setPreferredSize(new Dimension(800, 600));
        views.add(mainView, mainView.viewName);
        int numOfCooked = DAO.getNumOfCooked();
        mainView.setNumOfCooked(numOfCooked);
        // 这四句可以用来在一开始显示view
        viewManagerModel.setActiveView(mainView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);


        // 在数据库里写入一些菜谱
        RecipePresetter recipePresetter = new RecipePresetter();
        FileRecipeDataAccessObject prDAO = new FileRecipeDataAccessObject("recipes.json");
        recipePresetter.presetData(prDAO);
        // 创建并将视图添加到主面板:仓库视图
        WarehouseView warehouseView = WarehouseViewUseCaseFactory.create(viewRecipeViewModel, viewWarehouseViewModel,viewManagerModel, warehouseDAO, clickSearchViewModel, backViewModel);
        views.add(warehouseView, warehouseView.viewName);


        // viewManagerModel.setActiveView(warehouseView.viewName);//这样写，还是什么都没显示，说明就是warehouseView的问题
        // viewManagerModel.firePropertyChanged();
        // 创建并将视图添加到主面板:收藏夹视图
        FavoritesView favoritesView = FavoritesViewUseCaseFactory.create(viewRecipeViewModel, viewManagerModel, viewFavoritesViewModel, warehouseDAO,backViewModel);
        views.add(favoritesView, favoritesView.viewName);
        // 创建并将视图添加到主面板:编辑菜谱视图
        EditRecipeView editRecipeView = EditRecipeViewUseCaseFactory.create(backViewModel, viewManagerModel, createRecipeViewModel, jumpToEditViewModel, DAO);
        views.add(editRecipeView, editRecipeView.viewName);
        // 创建并将视图添加到主面板:查看菜谱视图
        ReadRecipeView viewRecipeView = ReadRecipeViewUseCaseFactory.create(backViewModel, viewManagerModel, createRecipeViewModel, viewRecipeViewModel, addToFavoritesViewModel, cookedViewModel, jumpToEditViewModel, showDailySpecialViewModel, viewRecipeDAO);
        views.add(viewRecipeView, viewRecipeView.viewName);
        // 创建并将视图添加到主面板:搜索菜谱视图
        SearchView viewSearchView = ViewSearchUseCaseFactory.create(viewSearchViewModel, viewManagerModel, backViewModel, clickSearchViewModel, DAO);
        views.add(viewSearchView.getSearchPanel(), viewSearchView.viewName);
    }
// 之前写的main被我删了重写了一个
}

