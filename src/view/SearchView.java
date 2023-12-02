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

public class SearchView implements ActionListener, PropertyChangeListener{

    public final String viewName = "search";

    private JPanel LabelPanel;
    private JLabel title;
    private JTextField searchTextField;
    private JButton buttonSearch;
    private JButton returnButton;
    private JPanel SearchPanel;

    // Use Case: Back
    private BackController backController;
    private BackViewModel backViewModel;

    //Use Case: Search
    private ViewSearchController searchController;
    private ViewSearchViewModel searchViewModel;


    public JPanel getSearchMainPanel() {
        return SearchPanel;
    }

    public SearchView(BackController backController, BackViewModel backViewModel, ViewSearchController viewSearchController, ViewSearchViewModel viewSearchViewModel){
        initComponents();


        this.backController = backController;
        this.backViewModel = backViewModel;
        this.searchController = viewSearchController;
        this.searchViewModel = viewSearchViewModel;
        this.searchViewModel.addPropertyChangeListener(this);

//        JFrame frame = new JFrame("SearchView");
//        frame.setContentPane(new SearchView(backController, backViewModel, viewSearchController, viewSearchViewModel).SearchPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
        // 这个好像也没用

        //界面元素
//        title = new JLabel("Search");
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//        buttonSearch = new JButton("Search");
//        returnButton = new JButton("Return");
//        searchTextField = new JTextField(15);

        // 设置布局
//        this.setLayout(new CardLayout()); // For example, using FlowLayout
//        this.add(title);
//        this.add(searchTextField);
//        this.add(buttonSearch);
//        this.add(returnButton);



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


        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(returnButton)) {
                }
                // 处理取消按钮点击事件，可能需要关闭编辑界面
                // 执行取消逻辑...
                backController.execute();
            }
        });
    }

    private void initComponents() {
        // 创建并设置 SearchPanel
        SearchPanel = new JPanel();
        // 可以在这里添加其他组件设置，比如布局等

        // 创建按钮并添加事件监听器
        buttonSearch = new JButton("Search");
        buttonSearch.addActionListener(this);

        returnButton = new JButton("Return");
        returnButton.addActionListener(this);

        searchTextField = new JTextField(15);
        searchTextField.addActionListener(this);

        // 添加按钮到面板
        SearchPanel.add(buttonSearch);
        SearchPanel.add(returnButton);
        SearchPanel.add(searchTextField);

        // 其他组件的初始化...
    }

//    private void initComponents() {
//    }


    public JPanel getSearchView() {
        return SearchPanel;
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

    public JPanel getSearchPanel() {
        return SearchPanel;
    }


}
