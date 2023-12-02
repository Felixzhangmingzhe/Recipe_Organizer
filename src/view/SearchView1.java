package view;

import interface_adapter.Back.BackController;
import interface_adapter.Back.BackViewModel;
import interface_adapter.view_search.ViewSearchController;
import interface_adapter.view_search.ViewSearchState;
import interface_adapter.view_search.ViewSearchViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchView1 implements ActionListener, PropertyChangeListener{

    public final String viewName = "search";

    private JPanel LabelPanel;
    private JLabel title;
    private JTextField searchFieldTextField;
    private JButton buttonSearch;
    private JButton returnButton;
    private JPanel SearchMainPanel;

    // Use Case: Back
    private BackController backController;
    private BackViewModel backViewModel;

    //Use Case: Search
    private ViewSearchController searchController;
    private ViewSearchViewModel searchViewModel;

    public JPanel getSearchMainPanel() {
        return SearchMainPanel;
    }

    public SearchView1(BackController backController, BackViewModel backViewModel, ViewSearchController viewSearchController, ViewSearchViewModel viewSearchViewModel){
//        initComponents();
        this.backController = backController;
        this.backViewModel = backViewModel;
        this.searchController = viewSearchController;
        this.searchViewModel = viewSearchViewModel;
        this.searchViewModel.addPropertyChangeListener(this);

        //界面元素
        title = new JLabel("Search");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonSearch = new JButton("Search");
        returnButton = new JButton("Return");
        searchFieldTextField = new JTextField(15);

        // 设置布局
//        this.setLayout(new CardLayout()); // For example, using FlowLayout
//        this.add(title);
//        this.add(searchFieldTextField);
//        this.add(buttonSearch);
//        this.add(returnButton);







        returnButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(returnButton)) {
                        }
                        // 处理取消按钮点击事件，可能需要关闭编辑界面
                        // 执行取消逻辑...
                        backController.execute();
                    }
                }
        );

        buttonSearch.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(buttonSearch)) {
                        }
                        // 处理取消按钮点击事件，可能需要关闭编辑界面
                        // 执行取消逻辑...
                        searchController.execute();
                    }
                }
        );


    }

//    private void initComponents() {
//    }


    public JPanel getSearchView() {
        return SearchMainPanel;
    }

//    public SearchView() {
//        //不知道干嘛因为不会空着来吧
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSearch) {
//            // 处理保存按钮点击事件，可能需要获取输入的菜谱信息并保存
//            String recipeName = recipeNameField.getText();
//            String recipeContent = recipeContentArea.getText();
            searchController.execute();
            // 执行保存逻辑...
        } else if (e.getSource() == returnButton) {
            // 处理取消按钮点击事件，可能需要关闭编辑界面
            // 执行取消逻辑...
            backController.execute();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ViewSearchState currentState = searchViewModel.getState();
//        JOptionPane.showMessageDialog(this, currentState.getSearchResult());


    }
}
