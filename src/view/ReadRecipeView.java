package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class ReadRecipeView extends JFrame implements ActionListener{
    JPanel searchPanel;// 用来放搜索框和搜索按钮，以及显示搜索结果
    JPanel recipePanel;// 用来显示菜谱
    JPanel editPanel;// 用来放编辑按钮，以及显示编辑过程
    // 用来用来搜索的存储菜谱
    private List<String> recipes = new ArrayList<>();
    private JTextField searchTextField;
    private Connection getConnection() throws SQLException {
        // 这里假设你在数据库中有一个名为recipes的表，包含一个名为name的列存储菜谱名
        // 这里是chatgpt给我的示例代码，具体要看我们选择的数据库
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";
        String password = "your_password";
        return DriverManager.getConnection(url, username, password);
    }
    public ReadRecipeView() {
        // 创建搜索界面，包括搜索框和搜索按钮
        searchPanel = new JPanel();
        JButton searchButton = new JButton("Search Recipe");
        searchPanel.add(searchButton);// 将按钮添加到面板中
        searchButton.addActionListener(this);
        searchTextField = new JTextField(20);
        searchPanel.add(searchTextField);// 将搜索框添加到面板中
        // 在构造函数中初始化recipes列表
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name FROM recipes");

            while (resultSet.next()) {
                String recipeName = resultSet.getString("name");
                recipes.add(recipeName);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 注意，这里只是一个例子，具体要看我们选择的数据库
        // 创建编辑界面
        editPanel = new JPanel();
        JButton editButton = new JButton("Edit Recipe");
        editPanel.add(editButton);
        editButton.addActionListener(this);
        // 创建显示界面
        recipePanel = new JPanel();
        JButton recipeButton = new JButton("Recipe");
        recipePanel.add(recipeButton);
        recipeButton.addActionListener(this);
        // 默认显示显示界面
        showRecipePanel();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Search Recipe")) {
            showSearchPanel();
        } else if (e.getActionCommand().equals("Edit Recipe")) {
            showEditPanel();
        } else if (e.getActionCommand().equals("Recipe")) {
            showRecipePanel();
        }
    }
    private void showSearchPanel() {
        getContentPane().removeAll();
        getContentPane().add(searchPanel);
        revalidate();
        repaint();
    }// 用来显示搜索结果

    private void showEditPanel() {
        String searchText = searchTextField.getText().toLowerCase(); // 获取用户输入并转为小写
        List<String> matchingRecipes = new ArrayList<>();

        for (String recipe : recipes) {
            if (recipe.toLowerCase().contains(searchText)) {
                matchingRecipes.add(recipe);
            }
        }// 将匹配的菜谱添加到matchingRecipes列表中

        // 创建一个新的面板来显示搜索结果
        JPanel searchResultPanel = new JPanel();
        for (String recipe : matchingRecipes) {
            searchResultPanel.add(new JLabel(recipe));
        }

        getContentPane().removeAll();
        getContentPane().add(searchResultPanel);
        revalidate();
        repaint();
    }// 用来显示编辑界面

    private void showRecipePanel() {
        getContentPane().removeAll();
        getContentPane().add(recipePanel);
        revalidate();
        repaint();
    }// 用来显示显示界面

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReadRecipeView view = new ReadRecipeView();
            view.setVisible(true);
        });
    }// 用来显示搜索界面
}